import org.example.base.BaseClass;
import org.example.base.Logout;
import org.testng.annotations.Test;

public class LoginRunner extends Login {

    public LoginRunner() {
    }

    @Test
    public void loginRunner() {
        Login ln = new Login();
        Logout logout=new Logout();
        ln.signIn();
        ln.cred();
        ln.closeModal();
        String balance=ln.balance();
        if(!balance.isEmpty()){
            System.out.println("Balance seen on the UI is as follows: "+balance);
        }
        else{
            throw new Error("Login failed");
        }
        logout.logOut();

    }
}
