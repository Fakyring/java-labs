public class AddressTest {
    public static void main(String[] args) {
        Address address = new Address("a: b: c: d e: f, g.");
        System.out.println(address.toString());

        address = new Address("a, b, c, d, e, f, g");
        System.out.println(address.toString());

        address = new Address("a. b c: d, e.: f, g");
        System.out.println(address.toString());

        address = new Address("a b c d e f g");
        System.out.println(address.toString());
    }
}