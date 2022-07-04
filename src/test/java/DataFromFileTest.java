import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DataFromFileTest extends BaseTest{
    @Test
    @Description("Data from txt file - txt file contains name, bio and phone number")
    public void RegistrationDataTest(){
        navigation("https://lennertamas.github.io/roxo/");
        registration("Agi", "xx18Cc!", "minonatv@gmail.com", "");
        login("Agi", "xx18Cc!");

        Profile profile = new Profile(driver);
        profile.ClickOnProfile();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "RegistrationData.txt"));
            String line = reader.readLine();
            while (line != null) {
                // read next line
                profile.InputData(line, line, line);
                Thread.sleep(2000);
                profile.ClickSaveButton();
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        profile.ClickSaveButton();
        Assertions.assertTrue(profile.isRegistrationValidVisible());
    }
    @Test
    @Description("Data from txt file - txt file contains nothing")
    public void RegistrationDataTestNull(){
        navigation("https://lennertamas.github.io/roxo/");
        registration("Agi", "xx18Cc!", "minonatv@gmail.com", "");
        login("Agi", "xx18Cc!");

        Profile profile = new Profile(driver);
        profile.ClickOnProfile();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "RegistrationDataNothing.txt"));
            String line = reader.readLine();
            while (line != null) {
                // read next line
                profile.InputData(line, line, line);
                Thread.sleep(2000);
                profile.ClickSaveButton();
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        profile.ClickSaveButton();
        Assertions.assertFalse(profile.isRegistrationValidVisible());
    }
}
