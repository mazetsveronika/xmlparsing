package by.mazets.xmlparsing.builder;
import by.mazets.xmlparsing.entity.Voucher;
import by.mazets.xmlparsing.handler.VoucherErrorHandler;
import by.mazets.xmlparsing.handler.VoucherHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Set;

public class VoucherSaxBuilder extends AbstractVoucherBuilder {
    private Set<Voucher> vouchers;
    private final VoucherHandler handler = new VoucherHandler();
    private XMLReader reader;
    public VoucherSaxBuilder() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            reader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        reader.setErrorHandler(new VoucherErrorHandler());
        reader.setContentHandler(handler);
    }
    public Set<Voucher> getVouchers() {
        return vouchers;
    }
    public void buildSetVouchers(String filename) {
        try {
            reader.parse(filename);
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
        vouchers = handler.getVouchers();
    }

}