
import io.appium.java_client.AppiumBy;

import org.example.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Login extends BaseClass {

    public Login() {
    }

    public void signIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(AppiumBy.accessibilityId("LOGIN"))));
        driver.findElement(AppiumBy.accessibilityId("LOGIN")).click();
    }

    public void cred() {
        driver.findElement(By.xpath("//android.widget.EditText[@hint=\"Mobile Number / Email\"]")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@hint=\"Mobile Number / Email\"]")).sendKeys(prop.getProperty("username"));
        driver.findElement(By.xpath("//android.widget.EditText[@hint=\"Password\"]")).click();
        driver.findElement(By.xpath("//android.widget.EditText[@hint=\"Password\"]")).sendKeys(prop.getProperty("password"));

        driver.findElement(AppiumBy.accessibilityId("LOGIN")).click();
    }

    public void closeModal(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View"))));
            driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View")).click();
        }
        catch(Exception ex){
            System.out.println("Modal view for ad not displayed in the login dashboard page");
        }
    }

    public String balance() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.widget.ImageView[ends-with(@content-desc,'Khalti Balance')]"))));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String Balance = driver.findElement(By.xpath("//android.widget.ImageView[ends-with(@content-desc,'Khalti Balance')]")).getAttribute("content-desc");
        System.out.println("Pre-Sender Balance: "+Balance.replace("/[\n]/g","").replace("Khalti Balance",""));
        return Balance.replace("/[\n]/g","").replace("Khalti Balance","");
    }
}