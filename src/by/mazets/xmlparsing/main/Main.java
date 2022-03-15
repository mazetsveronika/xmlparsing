package by.mazets.xmlparsing.main;
import java.io.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import by.mazets.xmlparsing.handler.ConsoleVoucherHandler;
import by.mazets.xmlparsing.handler.VoucherErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;


//public class Main {
    //public static void main(String[] args) {
/*     String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String fileName = "src/resources/data/vouchers.xml";
        String schemaName = "src/resources/data/vouchers.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            // schema creation
            Schema schema = factory.newSchema(schemaLocation);
            // creating a schema-based validator
            VoucherValidatorImpl validator = schema.newValidator();
            Source source = new StreamSource(fileName);
            // document check
            validator.setErrorHandler(new VoucherErrorHandler());
            validator.validate(source);
        } catch (SAXException | IOException e) {
            System.err.println(fileName + " is not correct or valid");
        }
    }
}


   */

      /*  try {
            // SAX parser creating & configuring
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(new ConsoleVoucherHandler());
            reader.setErrorHandler(new VoucherErrorHandler());
            reader.parse("resources/vouchers.xml");
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }


    }
}


       */




/*
        VoucherStaxBuilder staxBuilder = new VoucherStaxBuilder();
        staxBuilder.buildSetVouchers("src/resources/data/vouchers.xml");
        System.out.println(staxBuilder.getVouchers());

    }
}

 */


   /*     // Имя файла
        final String fileName = "src/resources/data/vouchers.xml";

        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            // Здесь мы определили анонимный класс, расширяющий класс DefaultHandler
            DefaultHandler handler = new DefaultHandler() {
                // Поле для указания, что тэг NAME начался
                boolean name = false;

                // Метод вызывается когда SAXParser "натыкается" на начало тэга
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    // Если тэг имеет имя NAME, то мы этот момент отмечаем - начался тэг NAME
                    if (qName.equalsIgnoreCase("NAME")) {
                        name = true;
                    }
                }

                // Метод вызывается когда SAXParser считывает текст между тэгами
                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    // Если перед этим мы отметили, что имя тэга NAME - значит нам надо текст использовать.
                    if (name) {
                        System.out.println("Name: " + new String(ch, start, length));
                        name = false;
                    }
                }
            };

            // Стартуем разбор методом parse, которому передаем наследника от DefaultHandler, который будет вызываться в нужные моменты
            saxParser.parse(fileName, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/
/*
        try {
            // SAX parser creating & configuring ok
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(new ConsoleVoucherHandler());
            reader.setErrorHandler(new VoucherErrorHandler());
            reader.parse("src/resources/data/vouchers.xml");
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }

 */





