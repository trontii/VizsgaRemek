import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Blog {

    public Blog(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    By blogButton = By.xpath("//*[@class=\"nav-link\" and @href=\"https://lennertamas.github.io/roxo/blog\"]"); //*[@class="navbar-nav ml-auto main-nav"]/li[4]
    By nextPageButton = By.xpath("//*[@class=\"pagination\"]/li[5]");
    By container = By.xpath("//section[@class=\"site-blog\"]//div[@class=\"col-lg-6\"]");

    public List<String> getBlogText(){
        List<String> result = new ArrayList<>();
        while (true) {

            List<WebElement> elements = driver.findElements(container);

            for (WebElement element : elements) {
                String name = element.findElement(By.xpath(".//a")).getText();
                result.add(name);
            }
            WebElement nextbutton = driver.findElement(nextPageButton);
            String cls = nextbutton.getAttribute("class");
            if (cls.contains("disabled")){
                break;
            }
            else {nextbutton.click();
            }
        }
        return result;
    }

    public void clickBlog(){
        driver.findElement(blogButton).click();
    }


}
