public class Tester {
    public static void main(String[] args) {
        Electronics el = new Electronics("PC", "i7 8700, gtx 1070", 70000);
        Stationery st = new Stationery("Pencil", 10, 100);
        System.out.println("Electronics: " + el.getPrice());
        System.out.println("Stationery: " + st.getCount() + " for: " + st.getPrice());
    }
}