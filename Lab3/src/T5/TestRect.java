package T5;

public class TestRect {
    public static void main(String[] args) {
        MovableRectangle mr = new MovableRectangle(5, 10, 10, 5, 10, 10);
        System.out.println(mr);
        mr.moveUp();
        mr.moveRight();
        System.out.println(mr);
    }
}