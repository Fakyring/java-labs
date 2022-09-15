package T1_2;

public class TestAbstract {
    public static void main(String[] args) {
        Circle c = new Circle();
        Rectangle re = new Rectangle();
        Square sq = new Square();

        System.out.println(c);
        System.out.println("Area: " + c.getArea());
        System.out.println("Perimeter: " + c.getPerimeter());
        System.out.println("Radius: " + c.getRadius());

        System.out.println(re);
        System.out.println("Area: " + re.getArea());
        System.out.println("Perimeter: " + re.getPerimeter());
        System.out.println("Width: " + re.getWidth());

        System.out.println(sq);
        System.out.println("Area: " + sq.getArea());
        System.out.println("Perimeter: " + sq.getPerimeter());
        System.out.println("Side: " + sq.getSide());
    }
}