package org.example.pageobject;

import io.appium.java_client.AppiumBy;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.example.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SendMoney extends BaseClass {

    public SendMoney() {
    }

    public void clickSendMoney() {

        driver.findElement(By.xpath("//android.view.View[@index='5']")).click();
        driver.findElement(AppiumBy.accessibilityId("Send to Khalti User\n" + "Transfer money to Khalti Friends")).click();
    }

    public void userDetail() {
        driver.findElement(By.xpath("//android.widget.EditText[@hint=\"Khalti Mobile Number\"]")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@hint=\"Khalti Mobile Number\"]")).sendKeys(prop.getProperty("username2"));

        driver.findElement(By.xpath("//android.widget.EditText[@hint=\"Amount\"]")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@hint=\"Amount\"]")).sendKeys(prop.getProperty("PayAmount"));

        driver.findElement(By.xpath("//android.widget.EditText[@hint=\"Remarks\"]")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@hint=\"Remarks\"]")).sendKeys("Send money");

        driver.hideKeyboard();

        driver.findElement(AppiumBy.accessibilityId("PAY RS. " + prop.getProperty("PayAmount"))).click();
        driver.findElement(AppiumBy.accessibilityId("OK")).click();
    }

    public void paymentPin() {

        driver.findElement(By.xpath("//android.widget.Button[@index='4']")).click();

        driver.findElement(By.xpath("//android.view.View[@index='2']//android.view.View[@index='0']")).click();
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0));

        driver.findElement(By.xpath("//android.view.View[@index='2']//android.view.View[@index='1']")).click();

        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0));

        driver.findElement(By.xpath("//android.view.View[@index='2']//android.view.View[@index='2']")).click();
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0));

        driver.findElement(By.xpath("//android.view.View[@index='2']//android.view.View[@index='3']")).click();
        driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0));

        driver.findElement(AppiumBy.accessibilityId("CONFIRM")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.accessibilityId("Success"))));

        driver.findElement(AppiumBy.accessibilityId("OK")).click();
    }

    public String transactionIdSender(){
        String transferDetail = driver.findElement(By.xpath("//android.view.View[starts-with(@content-desc,'Transfer')]")).getAttribute("content-desc");
        String []transaction=transferDetail.split("\n");
        String transactionId="";
        for(int i=0;i<transaction.length;i++){
            if(transaction[i].equals("Transaction ID:")){
                transactionId+=transaction[i+1];
            }
        }
        System.out.println("Transaction id is : " + transactionId);
        return transactionId;
    }


    public String postBalance() {
        String blnce = driver.findElement(By.xpath("//android.view.View[starts-with(@content-desc,'Amount')]")).getAttribute("content-desc");
        String[] split = blnce.split("\n");
        String postBalance = "";
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("Balance")) {
                postBalance += split[i + 1].replace("Rs. ", "");
            }
        }
        System.out.println("Post Sender Balance: " + postBalance);
        return postBalance;
    }

    public void homePage() {
        driver.findElement(AppiumBy.accessibilityId("Home\n" + "Tab 1 of 5")).click();
    }

    public String checkBalance() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.widget.ImageView[ends-with(@content-desc,'Khalti Balance')]"))));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String Balance = driver.findElement(By.xpath("//android.widget.ImageView[ends-with(@content-desc,'Khalti Balance')]")).getAttribute("content-desc");
        System.out.println(Balance.replace("/[\n]/g", "").replace("Khalti Balance", ""));
        return Balance.replace("/[\n]/g", "").replace("Khalti Balance", "");
    }
}
