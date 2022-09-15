package T1_2;

public class Rectangle extends Shape {
    protected double width, height;

    public Rectangle() {
        width = 10;
        height = 10;
    }

    public Rectangle(double w) {
        width = w;
        height = 10;
    }

    public Rectangle(double w, double h) {
        width = w;
        height = h;
    }

    public Rectangle(double w, double h, String cl) {
        width = w;
        height = h;
        color = cl;
    }

    public Rectangle(double w, double h, String cl, boolean fl) {
        width = w;
        height = h;
        color = cl;
        filled = fl;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle {" +
                "width=" + width +
                ", height=" + height +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
