package by.mazets.xmlparsing.handler;

public enum VoucherXmlTag {
        VOUCHERS("vouchers"),
        VOUCHER("voucher"),
        ID("id"),
        TYPE_OF_VOUCHER("typeOfVoucher"),
        COUNTRY("country"),
        CITY("city"),
        NUMBER_DAYS("numberDays"),
        NUMBER_NIGHTS("numberNights"),
        TRANSPORT("transport"),
        HOTEL_CHARACTERISTIC("hotelCharacteristic"),
        HOTEL_STARS("hotelStars"),
        HOTEL_ROOM("hotelRoom"),
        HOTEL_FOOD("hotelFood"),
        TV("tv"),
        AIR_CONDITIONER("airConditioner");
        private String value;
        VoucherXmlTag(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

