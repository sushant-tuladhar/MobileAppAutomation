import org.example.base.BaseClass;
import org.example.pageobject.Dashboard;
import org.junit.After;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DashboardValidatorTest extends BaseClass {
    Dashboard dashboard;

    DashboardValidatorTest(){
        dashboard=new Dashboard();
    }

    @BeforeTest
    public void setup(){
        login();
    }

    @Test
    public void dashboardValidation() throws InterruptedException {
        dashboard.transaction();
        dashboard.transactionLoadValidate();

        //Return back to home
        dashboard.home();

        dashboard.notifications();
        dashboard.notificationLoadValidate();

        //Return back to home
        dashboard.home();
    }

    @AfterTest
    public void tearDown(){
        logout();
        driver=null;
    }
}
