import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TermsAndConditions {
    WebDriver driver;

    public TermsAndConditions(WebDriver driver) {
        this.driver = driver;
    }

    public String url = "https://lennertamas.github.io/roxo/";
    By acceptButtonTerms = By.id ("terms-and-conditions-button");
    By termsX = By.xpath("//*[@onclick=\"closeModal()\"]");
    By popupNotExist = By.xpath("//*[@style=\"display: none;\" and @class=\"overlay\"]"); //before refresh
    By popupExist = By.xpath("//*[@style=\"display: block;\" and @class=\"overlay\"]");
    By popUp = By.id("overlay");

    public void navigate(){
        driver.get(url);
    }

    public void accept(){
        driver.findElement(acceptButtonTerms).click();
    }

    public void x(){
        driver.findElement(termsX).click();
    }

    public void refresh(){
        driver.navigate().refresh();
    }

    public String getElementBlock(){
        return driver.findElement(popupExist).getAttribute("style");
    }

    public String getElementNone(){
        return driver.findElement(popupNotExist).getAttribute("style");
    }

    public String popupGet(){
        return driver.findElement(popUp).getAttribute("style");
    }

    public boolean isTermsandConditionsVisible(){
        String style = driver.findElement(popUp).getAttribute("style");
        return style.equals("display: block;");
    }
}
