import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GetDataTest extends BaseTest{
    @Test
    public void getBlogDataTest(){
        navigation("https://lennertamas.github.io/roxo/");
        registration("Agi", "xx18Cc!", "minonatv@gmail.com", "");
        login("Agi", "xx18Cc!");

        Blog blog = new Blog(driver);
        blog.clickBlog();

        List<String> actual = blog.getBlogText();
        List<String> expected = new ArrayList<>();
        expected.add("Design Inspiration: The Best Projects From December");
        expected.add("The 10 Biggest Rebrands and Logo Designs of 2019");
        expected.add("Design Inspiration: The Best Projects From November");
        expected.add("Pt Chooses Classic Blue for Its Colour of the Year 2020");
        expected.add("The 10 Biggest Product Stories of 2019");

        Assertions.assertEquals(expected,actual);


    }
}
