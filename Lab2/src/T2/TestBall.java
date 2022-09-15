package T2;

public class TestBall {
    public static void main(String[] args) {
        Ball b = new Ball(3,0);
        System.out.println(b);
        b.move(10, 7);
        System.out.println(b);
    }
}