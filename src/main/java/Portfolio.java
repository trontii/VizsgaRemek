import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Portfolio {
    WebDriver driver;

    public Portfolio(WebDriver driver) {
        this.driver = driver;
    }

    By portfolioButton = By.xpath("//*[@class=\"nav-link\" and @href=\"https://lennertamas.github.io/roxo/portfolio\"]");
    By container = By.xpath("//*[@class= \"site-project\"]//div[@class=\"col-lg-6 col-md-10 mx-auto\"]");
    By secondButton = By.xpath("//*[@class=\"pagination\"]/li[4]");

    public void portfolioClick(){
        driver.findElement(portfolioButton).click();
    }

    public List<String> GetDataMultipleList() {
        List<String> result = new ArrayList<>();

        while (true) {
            List<WebElement> elements = driver.findElements(container);
            for (WebElement element : elements) {
                String name = element.findElement(By.xpath(".//div/div[2]/h3")).getText();
                result.add(name);
            }
            WebElement nextbutton = driver.findElement(secondButton);
            String cls = nextbutton.getAttribute("class");
            if (cls.contains("active")) {
                break;
            } else {
                nextbutton.click();
            }
        }
    return result;
    }
}

