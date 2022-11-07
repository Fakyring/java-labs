public class Phone {
    String phone;

    public String getPhone() {
        return phone;
    }

    public Phone(String phone) {
        int len = phone.length();
        phone = new StringBuffer(phone).insert(phone.length() - 4, "-").insert(phone.length() - 7, "-").toString();

        if (phone.charAt(0) != '+') {
            phone = phone.replace(phone.charAt(0), (char) ((int) phone.charAt(0) - 1));
            phone = new StringBuffer(phone).insert(0, "+").toString();
        }
        this.phone = phone;
    }
}