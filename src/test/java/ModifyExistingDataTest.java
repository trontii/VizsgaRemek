import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModifyExistingDataTest extends BaseTest{
    @Test
    @Description("Type in to the inputfields at Profile menu, then modify it")
    public void ModifyProfile(){
        navigation("https://lennertamas.github.io/roxo/");
        registration("Agi", "xx18Cc!", "minonatv@gmail.com", "");
        login("Agi", "xx18Cc!");

        Profile profile = new Profile(driver);
        profile.ClickOnProfile();
        profile.InputData("Peter", "male", "0044345666775" );
        profile.clearInputfields();
        profile.InputData("Kevin", "businessman", "0011222444455555" );

        Assertions.assertFalse(profile.inputfieldsIteration().isEmpty());
    }

    @Test
    @Description("Type in to the inputfields at Get in Touch menu, then modify it")
    public void ModifyGetInTouch(){
        navigation("https://lennertamas.github.io/roxo/");
        registration("Agi", "xx18Cc!", "minonatv@gmail.com", "");
        login("Agi", "xx18Cc!");

        GetInTouch getit = new GetInTouch(driver);
        getit.ClickGetInTouch();
        getit.FirstName("John");
        getit.LastName("Maverick");
        getit.Email("maverick@freemail.hu");
        getit.AboutTheProject("It's a Wonderful Project!");
        getit.clearInputfields();
        getit.FirstName("Max");
        getit.LastName("Johan");
        getit.Email("mjohan@freemail.hu");
        getit.AboutTheProject("This is the time to write a wonderful project!");
        //getit.clearInputfields();
        List<String> emptyornot = getit.inputfieldsIsEmpty();

        Assertions.assertEquals("", emptyornot);
    }
}
