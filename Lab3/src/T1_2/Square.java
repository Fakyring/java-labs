package T1_2;

public class Square extends Rectangle {
    private double side;

    public Square() {
        side = 5;
        width = side;
        height = side;
    }

    public Square(double sd) {
        side = sd;
        width = side;
        height = side;
    }

    public Square(double sd, String cl) {
        side = sd;
        color = cl;
        width = side;
        height = side;
    }

    public Square(double sd, String cl, boolean fl) {
        side = sd;
        color = cl;
        filled = fl;
        width = side;
        height = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double sd) {
        side = sd;
        width = side;
        height = side;
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        side = width;
        height = width;
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        side = height;
        width = height;
    }

    @Override
    public String toString() {
        return "Square {" +
                "side=" + side +
                ", width=" + width +
                ", height=" + height +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
