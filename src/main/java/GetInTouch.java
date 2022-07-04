import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class GetInTouch {
    WebDriver driver;

    public GetInTouch(WebDriver driver) {
        this.driver = driver;
    }

    By getintouchButton = By.xpath("//*[@class= \"nav-link btn btn-sm btn-primary btn-sm-rounded\"]");
    By FirstNameInput = By.id("first-name");
    By LastNameInput = By.id("last-name");
    By EmailInput = By.id("email");
    By ProjectType = By.id("projectType");
    By aboutProjectInput = By.id("aboutProject");
    By sendMessageButton = By.id("contact-form-button"); //button is not visible(=sending successfully) -- style= "display: none;"
    By ContactFormAcceptedText = By.id("contact-form-status"); //"OOps! There was a problem." "Thanks! Contact form is submitted successfully."
    //By Alert = By.xpath("//head/script[1]");


    public String FirstName(String fn){
        driver.findElement(FirstNameInput).sendKeys(fn);
        return fn;
    }

    public String LastName(String ln){
        driver.findElement(LastNameInput).sendKeys(ln);
        return ln;
    }

    public String Email(String e){
        driver.findElement(EmailInput).sendKeys(e);
        return e;
    }

    public String AboutTheProject(String ap){
        driver.findElement(aboutProjectInput).sendKeys(ap);
        return ap;
    }

    public void SelectProject(String p){ //Graphics Design -value = gd; Web Design -value = wd;
        Select select = new Select(driver.findElement(ProjectType));
        select.selectByValue(p);
    }

    public void ClickOnSendMessage(){
        driver.findElement(sendMessageButton).click();
    }

    public void ClickGetInTouch(){
        driver.findElement(getintouchButton).click();
    }

    public void ClickOkonAlert(){
        driver.switchTo().alert().accept();
    }

    public String GetTextOnAlert(){
        return driver.switchTo().alert().getText();
    }

    public String GetTextOnSendMessage(){
        return driver.findElement(ContactFormAcceptedText).getText();
    }

    public boolean sendingSuccessfull(){
        String style = driver.findElement(sendMessageButton).getAttribute("style");
        return style.equals("display: none;");
    }

    public void clearInputfields(){
        driver.findElement(FirstNameInput).clear();
        driver.findElement(LastNameInput).clear();
        driver.findElement(EmailInput).clear();
        driver.findElement(aboutProjectInput).clear();
    }

    public List<String> inputfieldsIsEmpty(){
        List<String> list = new ArrayList<>();
        list.add(driver.findElement(FirstNameInput).getText());
        list.add(driver.findElement(LastNameInput).getText());
        list.add(driver.findElement(EmailInput).getText());
        list.add(driver.findElement(aboutProjectInput).getText());
        return list;
    }
}
