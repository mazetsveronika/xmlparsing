package main.xmlparsing.validator.impl;

import main.xmlparsing.exception.VoucherException;
import main.xmlparsing.handler.VoucherErrorHandler;
import main.xmlparsing.validator.VoucherValidator;
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

    private static final String SCHEMA_NAME = "data/vouchers.xsd";
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

        ClassLoader loader = VoucherValidatorImpl.class.getClassLoader();
        URL resource = loader.getResource(SCHEMA_NAME);
        File schemaFile = new File(resource.getFile());

        URL resourceXML = loader.getResource(xmlFile);
        String xmlPath = new File(resourceXML.getFile()).getPath();
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        try {
            Schema schema = factory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlPath);
            validator.setErrorHandler(new VoucherErrorHandler());
            validator.validate(source);
        } catch (IOException e) {
            throw new VoucherException("Can't open file: " + xmlPath, e);
        } catch (SAXException e) {
            return false;
        }

        return true;
    }
}

