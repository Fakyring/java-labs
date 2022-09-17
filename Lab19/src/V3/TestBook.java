package V3;

public class TestBook {
    public static void main(String[] args) {
        Book b1 = new Book("John Smith", "Atlantis", 2005, 520);
        Book b2 = new Book("John Smith", "Atlantis");
        System.out.println("Pages: " + b2.getPages());
        b2.setName("Capital");
        System.out.println(b2 + "\n" + b1);
    }
}