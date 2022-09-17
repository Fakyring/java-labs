package T1_2;

public class Square extends Rectangle {

    public Square() {
        width = 5;
        height = 5;
    }

    public Square(double sd) {
        width = sd;
        height = sd;
    }

    public Square(double sd, String cl) {
        color = cl;
        width = sd;
        height = sd;
    }

    public Square(double sd, String cl, boolean fl) {
        color = cl;
        filled = fl;
        width = sd;
        height = sd;
    }

    public double getSide() {
        return width;
    }

    public void setSide(double sd) {
        width = sd;
        height = sd;
    }

    @Override
    public void setWidth(double width) {
        super.width = width;
    }

    @Override
    public void setHeight(double height) {
        super.height = height;
    }

    @Override
    public String toString() {
        return "Square {" +
                ", width=" + width +
                ", height=" + height +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
