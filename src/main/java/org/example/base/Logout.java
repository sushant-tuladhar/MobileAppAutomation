package org.example.base;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Logout extends BaseClass{

    public Logout(){
    }

    public void logOut(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Menu\nTab 5 of 5']"))));

        driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Menu\nTab 5 of 5']")).click();

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(\"Logout\n" +
                "Logout from your Khalti account\"));")).click(); //scroll down to the element and click

        //Logout button confirmation click on confirmation
        driver.findElement(AppiumBy.accessibilityId("YES")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.accessibilityId("LOGIN"))));
    }
}
