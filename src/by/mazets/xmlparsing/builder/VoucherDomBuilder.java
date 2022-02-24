package by.mazets.xmlparsing.builder;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import by.mazets.xmlparsing.entity.Voucher;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class VoucherDomBuilder extends AbstractVoucherBuilder {
        private Set<Voucher> vouchers;
        private DocumentBuilder docBuilder;
        public VoucherDomBuilder() {
            vouchers = new HashSet<Voucher>();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            try {
                docBuilder = factory.newDocumentBuilder();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            }
        }
    public Set<Voucher> getVouchers() {
        return vouchers;
    }
    public void buildSetVouchers(String filename) {
        Document doc;
        try {
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();
            NodeList vouchersList = root.getElementsByTagName("voucher");
            for (int i = 0; i < vouchersList.getLength(); i++) {
                Element voucherElement = (Element) vouchersList.item(i);
                Voucher voucher = buildVoucher(voucherElement);
                vouchers.add(voucher);
            }
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
    private Voucher buildVoucher(Element voucherElement) {
        Voucher voucher = new Voucher();
        voucher.setId(voucherElement.getAttribute("id"));
        voucher.setTypeOfVoucher(voucherElement.getAttribute("typeOfVoucher"));
        voucher.setCountry(voucherElement.getAttribute("country"));
        voucher.setCity(voucherElement.getAttribute("city"));
        Integer numberDays = Integer.parseInt(getElementTextContent(voucherElement,"numberDays"));
        voucher.setNumberDays(numberDays);
        Integer numberNights = Integer.parseInt(getElementTextContent(voucherElement,"numberNights"));
        voucher.setNumberNights(numberNights);
        voucher.setTransport(voucherElement.getAttribute("transport"));
        Voucher.HotelCharacteristic hotelCharacteristic = voucher.getHotelCharacteristic();
        Element hotelCharacteristicElement =(Element) voucherElement.getElementsByTagName("hotelCharacteristic").item(0);
        Integer hotelStars = Integer.parseInt(getElementTextContent(voucherElement,"hotelStars"));
        hotelCharacteristic.setHotelStars(hotelStars);
        hotelCharacteristic.setHotelRoom(getElementTextContent(hotelCharacteristicElement, "hotelRoom"));
        hotelCharacteristic.setHotelFood(getElementTextContent(hotelCharacteristicElement, "hotelFood"));
        hotelCharacteristic.setTv(getElementTextContent(hotelCharacteristicElement, "tv"));
        hotelCharacteristic.setAirConditioner(getElementTextContent(hotelCharacteristicElement, "airConditioner"));
        return voucher;
    }
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}

