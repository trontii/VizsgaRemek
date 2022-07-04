import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TermsAndConditionsTest extends BaseTest{

    @Test
    @Description("Check if we close the popup window and refresh the page, the popup window will come up again")
    public void termsTestX(){
        TermsAndConditions terms = new TermsAndConditions(driver);
        terms.navigate();
        terms.x();
        terms.refresh();

        String actual = terms.popupGet();
        String expected = terms.getElementBlock();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Description("Check if we accept the popup window and refresh the page, the popup window won't come up again")
    public void termsTestAccept() throws InterruptedException {
        TermsAndConditions terms = new TermsAndConditions(driver);
        terms.navigate();
        terms.accept();
        terms.refresh();

        Assertions.assertFalse(terms.isTermsandConditionsVisible());
    }
}
