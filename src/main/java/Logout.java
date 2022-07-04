import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout {

    WebDriver driver;

    public Logout(WebDriver driver) {
        this.driver = driver;
    }

    By logoutbutton = By.xpath("//a[@onclick=\"logout()\"]");
    By login = By.xpath("//div[@id=\"register\"]");

    public void clickonlogout(){
        driver.findElement(logoutbutton).click();
    }

    public boolean isTermsandConditionsVisible(){
        String style = driver.findElement(login).getAttribute("style");
        return style.equals("display: none;");
    }
}
