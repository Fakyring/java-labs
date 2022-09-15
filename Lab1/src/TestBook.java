public class TestBook {
    public static void main(String[] args) {
        Book b1 = new Book(500, "Slim Lion");
        Book b2 = new Book(800);
        Book b3 = new Book();
        b2.setName("Happy Man");
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        b2.getWeight();
    }
}