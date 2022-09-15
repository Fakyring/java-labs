package T4;

public class TestMovable {
    public static void main(String[] args) {
        MovablePoint mv = new MovablePoint(10, 0, 3, 7);
        MovableCircle mc = new MovableCircle(15, 20, 10, 40);
        System.out.println(mv.toString());
        System.out.println(mc.toString());
        mc.moveUp();
        mc.moveRight();
        System.out.println(mc);
    }
}