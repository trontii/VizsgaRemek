import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Home {

    WebDriver driver;

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    By namesinNameCard = By.xpath("//*[@class= \"col-lg-4 col-md-6\"]/div/div/div[@class=\"person\"]/h5");
    By nameCard = By.xpath("//*[@class= \"col-lg-4 col-md-6\"]");

    public List<String> getNames() {
        List<String> result = new ArrayList<>();
        List<WebElement> elements = driver.findElements(nameCard);
        for (WebElement element : elements) {
            String name = element.findElement(By.xpath(".//div/div/div[@class=\"person\"]/h5")).getText();
            result.add(name);
        }
        return result;
    }
}
