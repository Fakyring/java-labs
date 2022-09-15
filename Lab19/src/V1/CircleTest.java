package V1;

public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle(13, "Blue");
        Circle c2 = new Circle();

        System.out.println(c2.getRadius());
        c2.setRadius(20);
        System.out.println(c2.getRadius());
        System.out.println(c1);
    }
}