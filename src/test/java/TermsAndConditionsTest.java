import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TermsAndConditionsTest extends BaseTest{

    @Test
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
    public void termsTestAccept() throws InterruptedException {
        TermsAndConditions terms = new TermsAndConditions(driver);
        terms.navigate();
        terms.accept();
        terms.refresh();

        Assertions.assertFalse(terms.isTermsandConditionsVisible());
    }
}
