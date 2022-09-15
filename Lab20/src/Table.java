public class Table extends Furniture {
    private int legs;
    private boolean isAngled;

    public Table() {
        legs = 4;
        isAngled = true;
    }

    public Table(int l, boolean isA) {
        legs = l;
        isAngled = isA;
    }

    public int getLegs() {
        return legs;
    }

    public boolean isAngled() {
        return isAngled;
    }

    public void setAngled(boolean angled) {
        isAngled = angled;
    }

    public void setLegs(int legs) {
        this.legs = legs;
    }

    @Override
    public String toString() {
        return "Table {" +
                "legs=" + legs +
                ", width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                ", weight=" + weight +
                ", angled=" + isAngled +
                ", material='" + material + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}
