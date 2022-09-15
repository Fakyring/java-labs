public class Book {

    private int pages;
    private String name;

    public Book(int p, String n) {
        pages = p;
        name = n;
    }

    public Book(int p) {
        pages = p;
        name = "Lion The Fat";
    }

    public Book() {
        pages = 200;
        name = "Lion The Fat";
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int p) {
        pages = p;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String toString() {
        return pages + " - " + name;
    }

    public void getWeight() {
        System.out.println(pages * 1.5 + " grams");
    }
}
