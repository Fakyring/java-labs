public class Stationery implements Priceable {
    private String name;
    private double price;
    private int count;

    public Stationery(String name, double price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
