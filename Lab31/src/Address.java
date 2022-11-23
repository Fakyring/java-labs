import java.util.Random;

final class Address {
    private String cityName, streetName;
    private int zipCode, buildingNumber, apartmentNumber;
    private char buildingLetter;
    public Address EMPTY_ADDRESS;

    public String getCityName() {
        return cityName;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public char getBuildingLetter() {
        return buildingLetter;
    }

    public Address(String cityName, String streetName, int zipCode, int buildingNumber, int apartmentNumber, char buildingLetter) {
        this.cityName = cityName;
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = apartmentNumber;
        this.buildingLetter = buildingLetter;
    }

    public Address() {
        cityName = "Moscow";
        streetName = "Lenina";
        zipCode = new Random().nextInt(999999) + 100000;
        buildingNumber = new Random().nextInt(30);
        apartmentNumber = new Random().nextInt(100);
        buildingLetter = 'F';
    }
}
