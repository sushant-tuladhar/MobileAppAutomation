package org.example.base;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static AndroidDriver driver;
    public static Properties prop;
    private static final String propertyFilePath = "Configuration/Config.properties";

    @BeforeSuite(alwaysRun = true)
    public static void lunchApp() throws MalformedURLException {

        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability("platformName","Android");
        cap.setCapability("appium:automationName","UiAutomator2");
        cap.setCapability("appium:platformVersion","13");
        cap.setCapability("appium:appPackage", "com.khalti");
        cap.setCapability("appium:appActivity", "com.khalti.MainActivity");
        cap.setCapability("appium:autoGrantPermissions",true);


        URL url = new URL("http://127.0.0.1:4723/");

        driver = new AndroidDriver(url, cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Application started...");

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            prop = new Properties();
            try {
                prop.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    @AfterTest
    public void tearDown() {
        driver=null;
    }
}
