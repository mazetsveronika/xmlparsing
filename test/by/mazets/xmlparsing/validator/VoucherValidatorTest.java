package by.mazets.xmlparsing.validator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert.*;
import by.mazets.xmlparsing.exception.VoucherException;
import org.testng.annotations.Test;


public class VoucherValidatorTest {

    private static final String XML_FILE = "src/resources/data/vouchers.xml";
    private static final String XML_FILE_WRONG = "src/resources/data/vouchers.xml";
    private VoucherValidator voucherValidator;

    @BeforeClass
    public void setUp() {
        voucherValidator = new VoucherValidator();
    }

    @Test
    public void testIsValidXML() {

        boolean actual = false;
        try {
            actual = voucherValidator.isValidXML(XML_FILE);
        } catch (VoucherException e) {
            fail(e.getMessage(),e);
        }
        assertTrue(actual);
    }

    @Test
    public void testIsNotValid() {

        boolean actual = false;
        try {
            actual = voucherValidator.isValidXML(XML_FILE_WRONG);
        } catch (VoucherException e) {
            fail(e.getMessage(),e);
        }
        assertFalse(actual);
    }
}