public class Electronics implements Priceable{
    private String name, specs;
    private double price;
    public Electronics(String name, String specs, double price){
        this.name = name;
        this.specs = specs;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public String getName() {
        return name;
    }

    public String getSpecs() {
        return specs;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
