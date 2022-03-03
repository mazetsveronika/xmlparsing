package by.mazets.xmlparsing.handler;

public enum VoucherXmlTag {
        VOUCHERS("vouchers"),
        VOUCHER("voucher"),
        ID("id"),
        TYPEOFVOUCHER("typeOfVoucher"),
        COUNTRY("country"),
        CITY("city"),
        DEPARTURE("departure"),
        NUMBERDAYS("numberDays"),
        NUMBERNIGHTS("numberNights"),
        TRANSPORT("transport"),
        HOTELCHARACTERISTIC("hotelCharacteristic"),
        HOTELSTARS("hotelStars"),
        HOTELROOM("hotelRoom"),
        HOTELFOOD("hotelFood"),
        TV("tv"),
        AIRCONDITIONER("airConditioner");
        private String value;
        VoucherXmlTag(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

