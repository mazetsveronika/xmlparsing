package by.mazets.xmlparsing.entity;

import java.time.LocalDate;

public class Voucher{

    private String id;
    private String typeOfVoucher;
    private String country;
    private String city;
    private LocalDate departure;
    private Integer numberDays;
    private Integer numberNights;
    private String transport;
    private HotelCharacteristic hotelCharacteristic = new HotelCharacteristic();

      public Voucher(String id,  String typeOfVoucher, String country, String city, LocalDate departure, Integer numberDays,
                     Integer numberNights, String transport,HotelCharacteristic hotelCharacteristic ) {

        this.id = id;
        this.typeOfVoucher = typeOfVoucher;
        this.country = country;
        this.city = city;
        this.departure=departure;
        this.numberDays = numberDays;
        this.numberNights = numberNights;
        this.transport = transport;
        this.hotelCharacteristic=hotelCharacteristic;
    }

    public Voucher() {

    }
    public void setHotelCharacteristic(HotelCharacteristic hotelCharacteristic) {
        this.hotelCharacteristic = hotelCharacteristic;
    }

    public LocalDate getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDate departure) {
        this.departure = departure;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Voucher)) return false;

        Voucher voucher = (Voucher) o;

        if (getId() != null ? !getId().equals(voucher.getId()) : voucher.getId() != null) return false;
        if (getTypeOfVoucher() != null ? !getTypeOfVoucher().equals(voucher.getTypeOfVoucher()) : voucher.getTypeOfVoucher() != null)
            return false;
        if (getCountry() != null ? !getCountry().equals(voucher.getCountry()) : voucher.getCountry() != null)
            return false;
        if (getCity() != null ? !getCity().equals(voucher.getCity()) : voucher.getCity() != null) return false;
        if (getDeparture() != null ? !getDeparture().equals(voucher.getDeparture()) : voucher.getDeparture() != null)
            return false;
        if (getNumberDays() != null ? !getNumberDays().equals(voucher.getNumberDays()) : voucher.getNumberDays() != null)
            return false;
        if (getNumberNights() != null ? !getNumberNights().equals(voucher.getNumberNights()) : voucher.getNumberNights() != null)
            return false;
        if (getTransport() != null ? !getTransport().equals(voucher.getTransport()) : voucher.getTransport() != null)
            return false;
        return getHotelCharacteristic() != null ? getHotelCharacteristic().equals(voucher.getHotelCharacteristic()) : voucher.getHotelCharacteristic() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getTypeOfVoucher() != null ? getTypeOfVoucher().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getDeparture() != null ? getDeparture().hashCode() : 0);
        result = 31 * result + (getNumberDays() != null ? getNumberDays().hashCode() : 0);
        result = 31 * result + (getNumberNights() != null ? getNumberNights().hashCode() : 0);
        result = 31 * result + (getTransport() != null ? getTransport().hashCode() : 0);
        result = 31 * result + (getHotelCharacteristic() != null ? getHotelCharacteristic().hashCode() : 0);
        return result;
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nID: ");
        sb.append(id).append("\nType of voucher: ").append(typeOfVoucher);
        sb.append("\nCountry: ").append(country);
        sb.append("\nCity: ").append(city);
        sb.append("\nDeparture: ").append(departure);
        sb.append("\nNumber Days: ").append(numberDays);
        sb.append("\nNumber Nights: ").append(numberNights);
        sb.append("\nTransport: ").append(transport ).append(hotelCharacteristic);
        return sb.toString();
    }

    public static class HotelCharacteristic {
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
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof HotelCharacteristic)) return false;

            HotelCharacteristic that = (HotelCharacteristic) o;

            if (getHotelStars() != null ? !getHotelStars().equals(that.getHotelStars()) : that.getHotelStars() != null)
                return false;
            if (getHotelFood() != null ? !getHotelFood().equals(that.getHotelFood()) : that.getHotelFood() != null)
                return false;
            if (getHotelRoom() != null ? !getHotelRoom().equals(that.getHotelRoom()) : that.getHotelRoom() != null)
                return false;
            if (getTv() != null ? !getTv().equals(that.getTv()) : that.getTv() != null) return false;
            return getAirConditioner() != null ? getAirConditioner().equals(that.getAirConditioner()) : that.getAirConditioner() == null;
        }

        @Override
        public int hashCode() {
            int result = getHotelStars() != null ? getHotelStars().hashCode() : 0;
            result = 31 * result + (getHotelFood() != null ? getHotelFood().hashCode() : 0);
            result = 31 * result + (getHotelRoom() != null ? getHotelRoom().hashCode() : 0);
            result = 31 * result + (getTv() != null ? getTv().hashCode() : 0);
            result = 31 * result + (getAirConditioner() != null ? getAirConditioner().hashCode() : 0);
            return result;
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



