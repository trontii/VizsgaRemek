import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SaveTextFromPageTest extends BaseTest{
    @Test
    @Description("Save text from About menu")
    public void saveTextFromAboutTest(){
        navigation("https://lennertamas.github.io/roxo/");
        registration("Agi", "xx18Cc!", "minonatv@gmail.com", "");
        login("Agi", "xx18Cc!");

        About about = new About(driver);
        about.clickonabout();
        try {
              FileWriter myWriter = new FileWriter("savedata.txt");
              String text= about.gettext();
              myWriter.write(text);
              myWriter.close();
             }
        catch (IOException e) {
              e.printStackTrace();
        }

        BufferedReader reader;
        List<String> list = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(
                    "savedata.txt"));
            String line = reader.readLine();
            while (line != null) {
                // read next line
                list.add(line);
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        String expected = "[We are specialized in developing forward-thinking brand identities, websites, illustration and animation for all types of customers. And we do this by bringing our customers through each phase of the design process with us.]";

        String actual = list.toString();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Description("Save text from About Expertise list")
    public void saveTextExpertiselistTest(){
        navigation("https://lennertamas.github.io/roxo/");
        registration("Agi", "xx18Cc!", "minonatv@gmail.com", "");
        login("Agi", "xx18Cc!");

        About about = new About(driver);
        about.clickonabout();
        try {
            FileWriter myWriter = new FileWriter("savedata2.txt");
            List<String> expertiselist = about.gettextExpertiselist();
            myWriter.write(String.valueOf(expertiselist));
            myWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader reader;
        List<String> list = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(
                    "savedata2.txt"));
            String line = reader.readLine();
            while (line != null) {
                // read next line
                list.add(line);
                line = reader.readLine();
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        String expected = "[[Customer Experience Design, Digital Products, Development, Campaign & Content, Employer Branding, Animation & Motion Graphics, Packaging & Product Design, Retail & Spacial, Print & Editorial Design, Concept/Text, Information Design]]";

        String actual = list.toString();

        Assertions.assertEquals(expected, actual);
    }
}
