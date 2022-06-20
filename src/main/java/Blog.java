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

   // By blogDiv1 = By.xpath("(//*[@href=\"https://lennertamas.github.io/roxo/blog/design-inspiration-the-best-projects-from-december/\"])[1]");
   // By blogDiv2 = By.xpath("(//*[@href=\"https://lennertamas.github.io/roxo/blog/the-10-biggest-rebrands-and-logo-designs-of-2019/\"])[1]");
   // By blogDiv3 = By.xpath("(//*[@href=\"https://lennertamas.github.io/roxo/blog/design-inspiration-the-best-projects-from-november/\"])[1]");
   // By blogDiv4 = By.xpath("(//*[@href=\"https://lennertamas.github.io/roxo/blog/pt-chooses-classic-blue-for-its-colour-of-the-year-2020/\"])[1]");

   // By blogDiv5 = By.xpath("(//*[@href=\"https://lennertamas.github.io/roxo/blog/the-10-biggest-product-stories-of-2019/\"])[1]");

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

   // public String GetText1(){
   //     return driver.findElement(blogDiv1).getText();
  //  }

   // public String GetText2(){
    //    return driver.findElement(blogDiv2).getText();
   // }

   // public String GetText3(){
   //     return driver.findElement(blogDiv3).getText();
   // }

   // public String GetText4(){
   //     return driver.findElement(blogDiv4).getText();
    //}

   // public String GetText5(){
   //     return driver.findElement(blogDiv5).getText();
   // }

    public void clickBlog(){
        driver.findElement(blogButton).click();
    }

    public void clickNext(){
        driver.findElement(nextPageButton).click();
    }

}
