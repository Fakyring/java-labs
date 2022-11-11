public class Dish implements Item{
    private final String title;
    private final String description;
    private final int price;

    public Dish(String title, String description, int price) {
        if (price < 0 || description.isEmpty() || title.isEmpty()) throw new IllegalArgumentException();
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public Dish(String title, String description) {
        if (description.isEmpty() || title.isEmpty()) throw new IllegalArgumentException();
        this.title = title;
        this.description = description;
        price = 0;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
