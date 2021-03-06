package by.mazets.xmlparsing.validator.impl;

import by.mazets.xmlparsing.exception.VoucherException;
import by.mazets.xmlparsing.handler.VoucherErrorHandler;
import by.mazets.xmlparsing.validator.VoucherValidator;
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

public class VoucherValidatorImpl implements VoucherValidator {

    private static final String SCHEMA_NAME = "resources/vouchers.xsd";
    private static VoucherValidatorImpl instance;

    private VoucherValidatorImpl() {
    }

    public static VoucherValidatorImpl getInstance() {
        if (instance == null) {
            instance = new VoucherValidatorImpl();
        }
        return instance;
    }

    @Override
    public boolean validateXML(String xmlFile) throws VoucherException {

        String xmlPath = "";

        try {
            ClassLoader loader = this.getClass().getClassLoader();

            URL resource = loader.getResource(SCHEMA_NAME);
            File schemaFile = new File(resource.getFile());
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(schemaFile);
            Validator validator = schema.newValidator();

            URL resourceXML = loader.getResource(xmlFile);
            xmlPath = new File(resourceXML.getFile()).getPath();
            Source source = new StreamSource(xmlPath);

            validator.setErrorHandler(new VoucherErrorHandler());
            validator.validate(source);

        } catch (NullPointerException e){
            throw new VoucherException(e.getMessage(), e);
        } catch (IOException e) {
            throw new VoucherException("Cannot open file: " + xmlPath, e);
        } catch (SAXException e) {
            return false;
        }

        return true;
    }
}


