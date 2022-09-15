public class Sofa extends Furniture {
    private int doors, sections;
    private boolean hangBar;

    public Sofa() {
        doors = 2;
        sections = 4;
        hangBar = true;
    }

    public Sofa(int d, int s, boolean hB) {
        doors = d;
        sections = s;
        hangBar = hB;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getSections() {
        return sections;
    }

    public void setSections(int sections) {
        this.sections = sections;
    }

    public boolean isHangBar() {
        return hangBar;
    }

    public void setHangBar(boolean hangBar) {
        this.hangBar = hangBar;
    }

    @Override
    public String toString() {
        return "Sofa {" +
                "doors=" + doors +
                ", sections=" + sections +
                ", hangBar=" + hangBar +
                ", material='" + material + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                ", weight=" + weight +
                '}';
    }
}
