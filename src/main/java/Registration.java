import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registration {

    public Registration(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver driver;

    public String url = "https://lennertamas.github.io/roxo/";
    By termsButton = By.id ("terms-and-conditions-button");
    By registerButton1 = By.xpath("/html/body/div[2]/div[1]/button[1]");
    By usernameInput = By.id("register-username");
    By passwordInput = By.id("register-password");
    By emailInput = By.id("register-email");
    By descriptionInput = By.id("register-description");
    By registerButton2 = By.xpath("//*[@id=\"register\"]/form/div[6]/button");
    By userRegisteredAlert = By.id("register-alert");


    public void navigation() {

        driver.get(url);
    }

    public void clickAcceptTerms(){

        driver.findElement(termsButton).click();
    }

    public void clickRegisterButton1(){

        driver.findElement(registerButton1).click();
    }

    public void UserNameInput (String u){

        driver.findElement(usernameInput).sendKeys(u);
    }

    public void PasswordInput (String p){
        driver.findElement(passwordInput).sendKeys(p);
    }

    public void EmailInput(String e){

        driver.findElement(emailInput).sendKeys(e);
    }

    public void DescriptionInput(String d){

        driver.findElement(descriptionInput).sendKeys(d);
    }

    public void clickRegisterButton2(){

        driver.findElement(registerButton2).click();
    }

    public String userRegisteredAlert(){

        return driver.findElement(userRegisteredAlert).getText();
    }
}
