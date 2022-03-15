package test.mazets.xmlparsing.validator;
import by.mazets.xmlparsing.validator.impl.VoucherValidatorImpl;
import by.mazets.xmlparsing.exception.VoucherException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class VoucherValidatorImplTest {

        private static final String XML_FILE = "resources/vouchers.xml";
        private static final String XML_FILE_WRONG = "resources/vouchers_wrong.xml";
        private VoucherValidatorImpl validator;

        @BeforeClass

            public void setUp() {
                validator = VoucherValidatorImpl.getInstance();
            }

    @Test
    public void testIsValidateXML() {

        boolean actual = false;
        try {
            actual = validator.validateXML(XML_FILE);
        } catch (VoucherException e) {
            fail(e.getMessage(),e);
        }
        assertTrue(actual);
    }

    @Test
    public void testIsNotValidateXML() {

        boolean actual = false;
        try {
            actual = validator.validateXML(XML_FILE_WRONG);
        } catch (VoucherException e) {
            fail(e.getMessage(),e);
        }
        assertFalse(actual);

  }
}

