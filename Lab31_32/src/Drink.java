final class Drink extends MenuItem implements Alcoholable {
    private final double alcoholVol;
    private final DrinkTypeEnum type;

    public Drink(String name, String description, double cost, double alcoholVol, int type) {
        this.alcoholVol = alcoholVol;
        this.type = DrinkTypeEnum.values()[type];
        this.setName(name);
        this.setDescription(description);
        this.setCost(cost);
    }

    public Drink(String name, String description) {
        DrinkTypeEnum[] types = DrinkTypeEnum.values();
        this.alcoholVol = Math.random() * 10;
        this.type = types[(int) (Math.random() * types.length)];
        this.setName(name);
        this.setDescription(description);
    }

    public Drink() {
        DrinkTypeEnum[] types = DrinkTypeEnum.values();
        this.alcoholVol = 0;
        this.type = types[(int) (Math.random() * types.length)];
        this.setName("Name");
        this.setDescription("Description");
        this.setCost(100);
    }

    public DrinkTypeEnum getType() {
        return type;
    }

    @Override
    public void isAlcoholicDrink() {
        if (alcoholVol > 0) {
            System.out.println("Это алкоголь");
        } else
            System.out.println("Это не алкоголь");
    }

    @Override
    public double getAlcoholVol() {
        return 0;
    }

    private enum DrinkTypeEnum {
        Beer,
        WINE,
        VODKA,
        BRANDY,
        CHAMPAGNE,
        WHISKEY,
        TEQUILA,
        RUM,
        JUICE,
        COFFEE,
        MILK,
        WATER
    }
}
