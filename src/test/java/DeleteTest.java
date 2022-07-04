import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeleteTest extends BaseTest{
    @Test
    @Description("Type text in to get in Touch menu's input fields then delete it")
    public void deleteGetInTouch(){
        navigation("https://lennertamas.github.io/roxo/");
        registration("Agi", "xx18Cc!", "minonatv@gmail.com", "");
        login("Agi", "xx18Cc!");

        GetInTouch getintouch = new GetInTouch(driver);
        getintouch.ClickGetInTouch();
        getintouch.FirstName("John");
        getintouch.LastName("Maverick");
        getintouch.Email("maverick@freemail.hu");
        getintouch.AboutTheProject("It's a Wonderful Project!");
        getintouch.clearInputfields();
        Assertions.assertEquals("", "");
    }

    @Test
    @Description("Type text in to Profile menu's input fields then delete it")
    public void deleteProfile(){
        navigation("https://lennertamas.github.io/roxo/");
        registration("Agi", "xx18Cc!", "minonatv@gmail.com", "");
        login("Agi", "xx18Cc!");

        Profile profile = new Profile(driver);
        profile.ClickOnProfile();
        profile.InputData("Peter", "male", "0044345666775" );
        profile.clearInputfields();

        Assertions.assertFalse(profile.inputfieldsIteration().isEmpty());
    }
}
