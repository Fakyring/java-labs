import java.util.StringTokenizer;

public class Address {
    private final String country, region, city, street, house, frame, flat;

    public Address(String address) {
        address = address.trim();
        StringTokenizer strings = new StringTokenizer(address, " ,:.", false);
        country = strings.nextToken();
        region = strings.nextToken();
        city = strings.nextToken();
        street = strings.nextToken();
        house = strings.nextToken();
        frame = strings.nextToken();
        flat = strings.nextToken();
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                ", frame='" + frame + '\'' +
                ", flat='" + flat + '\'' +
                '}';
    }
}