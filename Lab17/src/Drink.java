public class Drink implements Item{
    private final String title;
    private final String description;
    private final int price;

    public Drink(String title, String description, int price) {
        if (price < 0 || description.isEmpty() || title.isEmpty()) throw new IllegalArgumentException();
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public Drink(String title, String description) {
        if (description.isEmpty() || title.isEmpty()) throw new IllegalArgumentException();
        this.title = title;
        this.description = description;
        price = 0;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }
}
