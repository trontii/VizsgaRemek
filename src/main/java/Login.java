import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    By loginButton1 = By.xpath("(//*[@id=\"login-form-button\"])[2]");
    By loginUserName = By.xpath("//*[@type=\"email\" and @id=\"email\"]");
    By loginPassword = By.id("password");
    By loginButton2 = By.xpath("//*[@type=\"button\" and @onclick=\"myFunction()\"]");

    public void clickLoginButton1(){

        driver.findElement(loginButton1).click();
    }

    public void loginUserNameInput(String un){

        driver.findElement(loginUserName).sendKeys(un);
    }

    public void loginPasswordInput(String pw){

        driver.findElement(loginPassword).sendKeys(pw);
    }

    public void clickLoginButton2(){

        driver.findElement(loginButton2).click();
    }
}
