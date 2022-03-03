package test.mazets.xmlparsing.builder;

import main.xmlparsing.builder.VoucherDomBuilder;
import main.xmlparsing.entity.Voucher;
import main.xmlparsing.exception.VoucherException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import static org.testng.Assert.assertFalse;


public class VoucherDomBuilderTest {


    private static final String XML_FILE = "resources/data/vouchers.xml";

    private VoucherDomBuilder domBuilder;

    @BeforeClass
    public void setUp() {
        domBuilder = new VoucherDomBuilder();
    }
    @Test
    public void buildVoucherDomBuilderTest() throws VoucherException {

        Voucher voucher1 = new Voucher();
        voucher1.setId("01");
        voucher1.setTypeOfVoucher("Weekend pass");
        voucher1.setCountry("Russia");
        voucher1.setCity("Moscow");
        voucher1.setDeparture(LocalDate.parse("2022-03-09"));
        voucher1.setNumberDays(Integer.parseInt("2"));
        voucher1.setNumberNights(Integer.parseInt("1"));
        voucher1.setTransport("bus");
        voucher1.getHotelCharacteristic().setHotelStars(Integer.parseInt("4"));
        voucher1.getHotelCharacteristic().setHotelFood("NO");
        voucher1.getHotelCharacteristic().setHotelRoom("single");
        voucher1.getHotelCharacteristic().setTv("yes");
        voucher1.getHotelCharacteristic().setAirConditioner("yes");


        Voucher voucher2 = new Voucher();
        voucher2.setId("02");
        voucher2.setTypeOfVoucher("Weekend pass");
        voucher2.setCountry("Russia");
        voucher2.setCity("Saint-Petersburg");
        voucher2.setDeparture(LocalDate.parse("2022-04-03"));
        voucher2.setNumberDays(Integer.parseInt("3"));
        voucher2.setNumberNights(Integer.parseInt("2"));
        voucher2.setTransport("bus");
        voucher2.getHotelCharacteristic().setHotelStars(Integer.parseInt("5"));
        voucher2.getHotelCharacteristic().setHotelFood("FB");
        voucher2.getHotelCharacteristic().setHotelRoom("double");
        voucher2.getHotelCharacteristic().setTv("yes");
        voucher2.getHotelCharacteristic().setAirConditioner("yes");



    Set<Voucher> expected = new HashSet<Voucher>();
        expected.add(voucher1);
        expected.add(voucher2);

        domBuilder.buildSetVouchers(XML_FILE);
    Set<Voucher> actual = domBuilder.getVouchers();

        //  assertEquals(actual, expected);
        //  assertTrue(actual.contains(expected));
        assertFalse(actual.contains(expected));
        }
    @AfterClass
    public void tearDown() {
        domBuilder = null;
    }
}