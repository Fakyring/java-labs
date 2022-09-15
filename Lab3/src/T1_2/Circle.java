package T1_2;

public class Circle extends Shape {
    protected double radius;

    public Circle() {
        radius = 5;
    }

    public Circle(double r) {
        radius = r;
    }

    public Circle(double r, String cl) {
        radius = r;
        color = cl;
    }

    public Circle(double r, String cl, boolean fl) {
        radius = r;
        color = cl;
        filled = fl;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle {" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
