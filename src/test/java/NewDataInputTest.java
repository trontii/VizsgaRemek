import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewDataInputTest extends BaseTest{
    @Test
    public void NewDataGetInTouch() throws InterruptedException {
        navigation("https://lennertamas.github.io/roxo/");
        registration("Agi", "xx18Cc!", "minonatv@gmail.com", "");
        login("Agi", "xx18Cc!");

        GetInTouch getintouch = new GetInTouch(driver);
        getintouch.ClickGetInTouch();
        getintouch.FirstName("Agi");
        getintouch.LastName("Simon");
        getintouch.Email("kkkk@gmail.com");
        getintouch.AboutTheProject("Wonderful project!");
        getintouch.SelectProject("wd");
        getintouch.ClickOnSendMessage();

       // WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3000));
        // presenceOfElementLocated condition
       // w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("\"//head/script[1]\"")));
        Thread.sleep(3000);

        getintouch.ClickOkonAlert();

        Thread.sleep(2000);
        String actual = getintouch.GetTextOnSendMessage();
        String expected = "Thanks! Contact form is submitted successfully.";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void NewDataInvalidEmailTest() throws InterruptedException {
        navigation("https://lennertamas.github.io/roxo/");
        registration("Agi", "xx18Cc!", "minonatv@gmail.com", "");
        login("Agi", "xx18Cc!");

        GetInTouch getintouch = new GetInTouch(driver);
        getintouch.ClickGetInTouch();
        getintouch.FirstName("Agi");
        getintouch.LastName("Simon");
        getintouch.Email("kkkkgmail.com");
        getintouch.AboutTheProject("Wonderful project!");
        getintouch.SelectProject("wd");
        getintouch.ClickOnSendMessage();

        // WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(3000));
        // presenceOfElementLocated condition
        // w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("\"//head/script[1]\"")));
        Thread.sleep(3000);
        getintouch.ClickOkonAlert();

        Assertions.assertFalse(getintouch.sendingSuccessfull());
    }
}
