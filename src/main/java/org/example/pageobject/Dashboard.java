package org.example.pageobject;

import io.appium.java_client.AppiumBy;
import org.example.base.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dashboard extends BaseClass {
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    public void transaction(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'Transaction')]"))));
        driver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'Transaction')]")).click();
    }

    public void home(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'Home')]"))));
        driver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'Home')]")).click();
    }

    public void support(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'Support')]"))));
        driver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'Support')]")).click();
    }


    public void scanAndPay(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView"))));
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.widget.ImageView")).click();
    }

    public void menu(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'Menu')]"))));
        driver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'Menu')]")).click();
    }

    public void notifications(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.ImageView[3]"))));
        driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.ImageView[3]")).click();
    }

    //Wait till the transactionDataIsLoaded
    public void transactionLoadValidate(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.view.View"))));
    }

    public void notificationLoadValidate(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.xpath("//android.widget.ScrollView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View"))));
    }

    public void supportLoadValidate(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc,'Help and Support')]"))));
    }

    public void menuLoadValidate(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'Khalti Quiz')]"))));
    }

    public void backButton(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.xpath("//android.widget.Button"))));
        driver.findElement(AppiumBy.xpath("//android.widget.Button")).click();
    }

    public void scanAndPayLoadValidate(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.accessibilityId("SHOW MY QR CODE"))));
    }

    public void scanAndPayBackButton(){
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.accessibilityId("Back"))));
        driver.findElement(AppiumBy.accessibilityId("Back")).click();
    }
}
