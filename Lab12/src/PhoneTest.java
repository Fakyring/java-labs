public class PhoneTest {
    public static void main(String[] args) {
        Phone phoneNumber = new Phone("+79175655655");
        System.out.println(phoneNumber.getPhone());

        phoneNumber = new Phone("+104289652211");
        System.out.println(phoneNumber.getPhone());

        phoneNumber = new Phone("89175655655");
        System.out.println(phoneNumber.getPhone());
    }
}