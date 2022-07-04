import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest{

    @Test
    @Description("Simple login with registered email address, name and password")
    public void logTest1() {
        registration("Agi", "xx18Cc!", "minonatv@gmail.com", "");
        login("Agi", "xx18Cc!");
        String expected = "https://lennertamas.github.io/roxo/landing.html";
        String actual = driver.getCurrentUrl();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Description("Simple login without registered data ")
    public void logTest2() { //nem regisztralt adatokkal próbálunk belépni
        registration("Agi", "xx18Cc!", "minonatv@gmail.com", "");
        login("Agi", "pppppp");
        String expected = "https://lennertamas.github.io/roxo/";
        String actual = driver.getCurrentUrl();

        Assertions.assertEquals(expected, actual);
    }

}
