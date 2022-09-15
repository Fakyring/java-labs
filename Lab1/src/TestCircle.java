public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle(3, "Green");
        Circle c2 = new Circle(8);
        Circle c3 = new Circle();
        c1.setColor("Blue");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        c2.getArea();
    }
}
