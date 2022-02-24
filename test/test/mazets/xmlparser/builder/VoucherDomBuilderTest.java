package test.mazets.xmlparser.builder;
import by.mazets.xmlparsing.builder.AbstractVoucherBuilder;
import  by.mazets.xmlparsing.builder.VoucherBuilderFactory;
import by.mazets.xmlparsing.exception.VoucherException;
import by.mazets.xmlparsing.entity.Voucher;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import by.mazets.xmlparsing.builder.VoucherBuilderFactory.TypeParser.DOM;
import  org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;


    public class VoucherDomBuilderTest {
        private static final String VOUCHER_FILE = "src/resources/data/vouchers.xml";
        private AbstractVoucherBuilder builder;
        private Set<Voucher> expected;

        @BeforeClass
        public void setUp() {
            builder = VoucherBuilderFactory.createVoucherBuilder(String.valueOf(DOM));
            expected = new HashSet<>();
            expected.add(new Voucher("01", "Weekend pass", "Russia",
                    "Moscow", 2, 2, "bus"));
            expected.add(new Voucher().new HotelCharacteristic(4, "NO", "single", "yes", "yes"));

            @Test
            public void testBuild () {

                try {
                    ClassLoader loader = getClass().getClassLoader();
                    URL resource = loader.getResource(VOUCHER_FILE);
                    builder.buildSetVouchers(resource.getFile());
                } catch (VoucherException e) {
                    fail(e.getMessage(), e);
                }
                Set<Voucher> actual = builder.getVouchers();
                assertEquals(actual, expected);
            }
        }
    }



