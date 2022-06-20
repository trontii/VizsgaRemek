import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest{

    @Test
    public void logTest() throws InterruptedException {
        registration("Agi", "xx18Cc!", "minonatv@gmail.com", "");
        login("Agi", "xx18Cc!");
        String expected = "https://lennertamas.github.io/roxo/landing.html";
        String actual = driver.getCurrentUrl();

        Assertions.assertEquals(expected, actual);
    }

}
