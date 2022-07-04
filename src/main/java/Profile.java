import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Profile {

    WebDriver driver;

    public Profile(WebDriver driver)
    {
        this.driver = driver;
    }

    By ProfileButton = By.xpath("//p[@id=\"profile-btn\"]");
    By CloseIcon = By.xpath("//div[@class=\"CloseIcon\"]");
    By InputName = By.xpath("//input[@type=\"text\" and @id=\"name\"]");
    By InputBio = By.xpath("//input[@type=\"text\" and @id=\"bio\"]");
    By PhoneNumber = By.xpath("//input[@type=\"text\" and @id=\"phone-number\"]");
    By SaveProfileButton = By.xpath("//button[@type=\"button\" and @onclick=\"editUser()\"]");
    By ProfileEditedText = By.xpath("//p[@id=\"edit-alert\"]"); //style= "display: block;"
    By InputFields = By.xpath("//form[@class=\"form\"]/div/input");

    public void ClickOnProfile(){
        driver.findElement(ProfileButton).click();
    }

    public void ClickOnPopup(){
        driver.findElement(CloseIcon).click();
    }

    public void InputData(String name, String bio, String phonenumber){
        driver.findElement(InputName).sendKeys(name);
        driver.findElement(InputBio).sendKeys(bio);
        driver.findElement(PhoneNumber).sendKeys(phonenumber);
    }

    public void clearInputfields(){
        driver.findElement(InputName).clear();
        driver.findElement(InputBio).clear();
        driver.findElement(PhoneNumber).clear();
    }

    public List<String> inputfieldsIteration() {
            List<String> result = new ArrayList<>();
            List<WebElement> elements = driver.findElements(InputFields);
            for (WebElement element : elements) {
                String name = element.findElement(InputFields).getText();
                result.add(name);
            }
            return result;
        }

    public void ClickSaveButton(){
        driver.findElement(SaveProfileButton).click();
    }

    public boolean isRegistrationValidVisible(){
        String style = driver.findElement(ProfileEditedText).getAttribute("style");
        return style.equals("display: block;");
    }

}
