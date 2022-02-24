package by.mazets.xmlparsing.validator;
import by.mazets.xmlparsing.exception.VoucherException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class VoucherValidator {
    private static  Logger logger = LogManager.getLogger();
    private static final String SCHEMA_NAME = "src/resources/data/vouchers.xsd";

    public boolean isValidXML(String xmlFile) throws VoucherException {

        ClassLoader loader = VoucherValidator.class.getClassLoader();
        URL resource = loader.getResource(SCHEMA_NAME);
        assert resource != null;
        File schemaFile = new File(resource.getFile());

        URL resourceXML = loader.getResource(xmlFile);
        assert resourceXML != null;
        String xmlPath = new File(resourceXML.getFile()).getPath();
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        try {
            Schema schema = factory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlPath);
            validator.validate(source);
        } catch (IOException e) {
            logger.error("can NOT read file {}", xmlPath);
            throw new VoucherException("can NOT open file " + xmlPath, e);
        } catch (SAXException e) {
            logger.error("file {} is NOT valid", xmlPath, e);
            return false;
        }

        return true;
    }

}