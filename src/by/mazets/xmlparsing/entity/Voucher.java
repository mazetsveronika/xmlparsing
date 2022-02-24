package by.mazets.xmlparsing.entity;

public class Voucher {


    private String id;
    private String typeOfVoucher;
    private String country;
    private String city;
    private Integer numberDays;
    private Integer numberNights;
    private String transport;
    private HotelCharacteristic hotelCharacteristic = new HotelCharacteristic();

    public Voucher() {

    }

    public Voucher(String id, String typeOfVoucher, String country, String city,
                   Integer numberDays, Integer numberNights, String transport) {

        this.id = id;
        this.typeOfVoucher = typeOfVoucher;
        this.country = country;
        this.city = city;
        this.numberDays = numberDays;
        this.numberNights = numberNights;
        this.transport = transport;
    }



    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public String getTypeOfVoucher() {

        return typeOfVoucher;
    }

    public void setTypeOfVoucher(String typeOfVoucher) {

        this.typeOfVoucher = typeOfVoucher;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getNumberDays() {
        return numberDays;
    }

    public void setNumberDays(Integer numberDays) {
        this.numberDays = numberDays;
    }

    public Integer getNumberNights() {
        return numberNights;
    }

    public void setNumberNights(Integer numberNights) {
        this.numberNights = numberNights;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public HotelCharacteristic getHotelCharacteristic() {
        return hotelCharacteristic;
    }

    public void setHotelCharacteristic(String HotelCharacteristic) {
        this.hotelCharacteristic = hotelCharacteristic;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nID: ");
        sb.append(id).append("\nType of voucher: ").append(typeOfVoucher);
        sb.append("\nCountry: ").append(country);
        sb.append("\nCity: ").append(city);
        sb.append("\nNumber Days: ").append(numberDays);
        sb.append("\nNumber Nights: ").append(numberNights);
        sb.append("\nTransport: ").append(transport ).append(hotelCharacteristic);
        return sb.toString();
    }


    public class HotelCharacteristic extends Voucher {
            private Integer hotelStars;
            private String hotelFood;
            private String hotelRoom;
            private String tv;
            private String airConditioner;

            public HotelCharacteristic() {
            }

            public HotelCharacteristic(Integer hotelStars, String hotelFood, String hotelRoom,
                                       String tv, String airConditioner) {
                this.hotelStars = hotelStars;
                this.hotelFood = hotelFood;
                this.hotelRoom = hotelRoom;
                this.tv = tv;
                this.airConditioner = airConditioner;

            }


        public Integer getHotelStars() {
                return hotelStars;
            }

            public void setHotelStars(Integer hotelStars) {
                this.hotelStars = hotelStars;
            }

            public String getHotelFood() {
                return hotelFood;
            }

            public void setHotelFood(String hotelFood) {
                this.hotelFood = hotelFood;
            }

            public String getHotelRoom() {
                return hotelRoom;
            }

            public void setHotelRoom(String hotelRoom) {
                this.hotelRoom = hotelRoom;
            }

            public String getTv() {
                return tv;
            }

            public void setTv(String tv) {
                this.tv = tv;
            }

            public String getAirConditioner() {
                return airConditioner;
            }

            public void setAirConditioner(String airConditioner) {
                this.airConditioner = airConditioner;
            }


        @Override
        public String toString() {
          final StringBuilder sb = new StringBuilder("\nHotel Characteristic:\n\tHotel Stars:");
                sb.append(hotelStars).append("\n\tHotel Food: ").append(hotelFood);
            sb.append("\nHotel Room: ").append(hotelRoom);
            sb.append("\ntv: ").append(tv);
            sb.append("\nairConditioner: ").append(airConditioner).append('\n');
                return sb.toString();
            }

        }
    }



