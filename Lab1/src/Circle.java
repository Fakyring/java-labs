public class Circle {
    private double radius;
    private String color;

    public Circle(double r, String cl) {
        radius = r;
        color = cl;
    }

    public Circle(double r) {
        radius = r;
        color = "Red";
    }

    public Circle() {
        radius = 5;
        color = "Red";
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double r) {
        radius = r;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String cl) {
        color = cl;
    }

    public String toString() {
        return radius + " - " + color;
    }

    public void getArea() {
        System.out.println(Math.PI * Math.pow(radius, 2));
    }
}