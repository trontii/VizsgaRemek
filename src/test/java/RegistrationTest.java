import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static java.time.Duration.ofSeconds;

public class RegistrationTest extends BaseTest{

    @Test
    public void regTest(){
        registration("Agi", "xx18Cc!", "minonatv@gmail.com", "");
        Registration regPage = new Registration(driver);
        String actual = regPage.userRegisteredAlert();
        String expected = "User registered!";

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void registrationTest2(){
        registration("hhh", "xx!", "minonatvgmail.com", "");
        Registration regPage = new Registration(driver);
        String actual = regPage.userRegisteredAlert();
        String expected = "Invalid email!";
        Assertions.assertEquals(expected, actual);
    }

}
