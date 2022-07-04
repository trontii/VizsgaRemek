import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;

    @BeforeEach
    public void setup()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void login(String name, String password) {

        Login login = new Login(driver);
        login.clickLoginButton1();
        login.loginUserNameInput(name);
        login.loginPasswordInput(password);
        login.clickLoginButton2();
    }

    public void registration(String username, String pw, String email, String description) {
        Registration registration = new Registration(driver);
        registration.navigation();
        registration.clickAcceptTerms();
        registration.clickRegisterButton1();
        registration.UserNameInput(username);
        registration.PasswordInput(pw);
        registration.EmailInput(email);
        registration.DescriptionInput(description);
        registration.clickRegisterButton2();
    }

    public void navigation(String url){
        url = "https://lennertamas.github.io/roxo/";
        driver.navigate().to(url);
    }

    //@AfterEach
    //public void quit() {
     //  driver.quit();
    //}
}
