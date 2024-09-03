import org.example.pageobject.Login;
import org.testng.annotations.Test;

public class LoginRunnerTest extends Login {

    public LoginRunnerTest() {
    }

    @Test
    public void loginRunner() {
        login();
        logout();
    }
}
