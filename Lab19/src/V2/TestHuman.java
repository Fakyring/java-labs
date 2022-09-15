package V2;

public class TestHuman {
    public static void main(String[] args) {
        Human h = new Human("John");
        h.Head.setEars(3);
        System.out.println(h.Leg.getFingers());
        h.Leg.setFingers(4);
        System.out.println(h);
        System.out.println(h.Head);
        System.out.println(h.Leg);
        System.out.println(h.Hand);
    }
}