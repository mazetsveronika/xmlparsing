package test.mazets.xmlparsing.validator;
import main.xmlparsing.validator.impl.VoucherValidatorImpl;
import main.xmlparsing.exception.VoucherException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class VoucherValidatorImplTest {

        private static final String XML_FILE = "resources/data/vouchers.xml";
        private static final String XML_FILE_WRONG = "resources/data/vouchers_wrong.xml";
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

