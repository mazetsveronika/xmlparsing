package by.mazets.xmlparsing.builder;
import by.mazets.xmlparsing.entity.Voucher;
import by.mazets.xmlparsing.handler.VoucherXmlTag;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class VoucherStaxBuilder extends AbstractVoucherBuilder {
    private Set<Voucher> vouchers;
    private XMLInputFactory inputFactory;
    public VoucherStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        vouchers = new HashSet<Voucher>();
    }
    public Set<Voucher> getVouchers() {
        return vouchers;
    }
    public void buildSetVouchers(String filename) {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(new File(filename))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(VoucherXmlTag.VOUCHER.getValue())) {
                        Voucher voucher = buildVoucher(reader);
                        vouchers.add(voucher);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Voucher buildVoucher(XMLStreamReader reader)
            throws XMLStreamException {
        Voucher voucher = new Voucher();
        voucher.setId(reader.getAttributeValue(null, VoucherXmlTag.ID.getValue()));
        voucher.setTypeOfVoucher(reader.getAttributeValue(null,
                VoucherXmlTag.TYPE_OF_VOUCHER.getValue()));
        voucher.setCountry(reader.getAttributeValue(null,
                VoucherXmlTag.COUNTRY.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (VoucherXmlTag.valueOf(name.toUpperCase())) {
                        case TYPE_OF_VOUCHER -> voucher.setTypeOfVoucher(getXMLText(reader));
                        case COUNTRY -> voucher.setCountry(getXMLText(reader));
                        case CITY -> voucher.setCity(getXMLText(reader));
                        case NUMBER_DAYS -> voucher.setNumberDays(Integer.parseInt(getXMLText(reader)));
                        case NUMBER_NIGHTS -> voucher.setNumberNights(Integer.parseInt(getXMLText(reader)));
                        case TRANSPORT -> voucher.setTransport(getXMLText(reader));
                        case HOTEL_CHARACTERISTIC -> voucher.setHotelCharacteristic(getXMLText(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (VoucherXmlTag.valueOf(name.toUpperCase()) == VoucherXmlTag.VOUCHER) {
                        return voucher;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <voucher>");
    }

    private Voucher.HotelCharacteristic getXMLHotelCharacteristic(XMLStreamReader reader)
            throws XMLStreamException {
        Voucher.HotelCharacteristic hotelCharacteristic = new Voucher().new HotelCharacteristic();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (VoucherXmlTag.valueOf(name.toUpperCase())) {
                        case HOTEL_STARS -> hotelCharacteristic.setHotelStars(Integer.parseInt(getXMLText(reader)));
                        case HOTEL_ROOM -> hotelCharacteristic.setHotelRoom(getXMLText(reader));
                        case HOTEL_FOOD -> hotelCharacteristic.setHotelFood(getXMLText(reader));
                        case TV -> hotelCharacteristic.setTv(getXMLText(reader));
                        case AIR_CONDITIONER -> hotelCharacteristic.setAirConditioner(getXMLText(reader));
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (VoucherXmlTag.valueOf(name.toUpperCase()) == VoucherXmlTag.HOTEL_CHARACTERISTIC) {
                        return hotelCharacteristic;
                    }
            }
        }
            throw new XMLStreamException("Unknown element in tag <hotelCharacteristic>");
        }
        private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
            String text = null;
            if (reader.hasNext()) {
                reader.next();
                text = reader.getText();
            }
            return text;
        }
    }


