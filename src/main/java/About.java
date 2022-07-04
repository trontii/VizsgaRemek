import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class About {
    WebDriver driver;

    public About(WebDriver driver) {
        this.driver = driver;
    }

    By aboutfirsttext = By.xpath("//div[@class=\"site-about-description\"]/p");
    By AboutButton = By.xpath("//a[@class=\"nav-link\" and @href=\"https://lennertamas.github.io/roxo/about\"]");
    By expertiselist = By.xpath("//ul[@class=\"site-expertise-list\"]/li"); //11


    public void clickonabout(){

        driver.findElement(AboutButton).click();
    }

    public String gettext(){
        String text= driver.findElement(aboutfirsttext).getText();
        return text;
    }

    public List<String> gettextExpertiselist(){
        List<String> result = new ArrayList<>();
        List<WebElement> explist = driver.findElements(expertiselist);
        for (int i = 0; i < explist.size(); i++){
            String e = explist.get(i).getText();
            result.add(e);
        }
        return result;
    }

}
