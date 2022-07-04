import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogoutTest extends BaseTest{
    @Test
    @Description("Simple logout from the page")
    public void LogoutTest(){
        navigation("https://lennertamas.github.io/roxo/");
        registration("Agi", "xx18Cc!", "minonatv@gmail.com", "");
        login("Agi", "xx18Cc!");

        Logout logout = new Logout(driver);
        logout.clickonlogout();
        Assertions.assertTrue(logout.isTermsandConditionsVisible());
    }
}
