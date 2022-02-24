package by.mazets.xmlparsing.handler;

import by.mazets.xmlparsing.entity.Voucher;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class VoucherHandler extends DefaultHandler {
    private Set<Voucher> vouchers;
    private Voucher current;
    private VoucherXmlTag currentXmlTag;
    private EnumSet<VoucherXmlTag> withText;
    private static final String ELEMENT_VOUCHER = "voucher";
    public VoucherHandler() {
        vouchers = new HashSet<Voucher>();
        withText = EnumSet.range(VoucherXmlTag.ID, VoucherXmlTag.TYPE_OF_VOUCHER);
    }

    public Set<Voucher> getVouchers() {
        return vouchers;
    }

   @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (ELEMENT_VOUCHER.equals(qName)) {
            current = new Voucher();
            current.setId(attrs.getValue(0));
            if (attrs.getLength() == 2) {
                current.setTypeOfVoucher(attrs.getValue(1));
            }
        } else {
            VoucherXmlTag temp = VoucherXmlTag.valueOf(qName.toUpperCase());
            if (withText.contains(temp)) {
                currentXmlTag = temp;
            }
        }
    }
    @Override
    public void endElement(String uri, String localName, String qName) {
        if (ELEMENT_VOUCHER.equals(qName)) {
            vouchers.add(current);
        }
    }
    @Override
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).strip();
        if (currentXmlTag!= null) {
            switch (currentXmlTag) {
                case ID -> current.setId(data);
                case TYPE_OF_VOUCHER -> current.setTypeOfVoucher(data);
                case COUNTRY -> current.setCountry(data);
                case CITY -> current.setCity(data);
                case NUMBER_DAYS -> current.setNumberDays(Integer.parseInt(data));
                case NUMBER_NIGHTS -> current.setNumberNights(Integer.parseInt(data));
                case TRANSPORT -> current.setTransport(data);
                case HOTEL_STARS -> current.getHotelCharacteristic().setHotelStars(Integer.parseInt(data));
                case HOTEL_ROOM -> current.getHotelCharacteristic().setHotelRoom(data);
                case TV -> current.getHotelCharacteristic().setTv(data);
                case AIR_CONDITIONER -> current.getHotelCharacteristic().setAirConditioner(data);

                default -> throw new EnumConstantNotPresentException(
                        currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
        currentXmlTag = null;
    }



}
