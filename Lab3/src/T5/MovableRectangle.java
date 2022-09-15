package T5;

import T4.Movable;
import T4.MovablePoint;

public class MovableRectangle implements Movable {
    private MovablePoint tl, br;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        tl = new MovablePoint(x1, y1, xSpeed, ySpeed);
        br = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    @Override
    public void moveUp() {
        tl.moveUp();
        br.moveUp();
    }

    @Override
    public void moveDown() {
        tl.moveDown();
        br.moveDown();
    }

    @Override
    public void moveLeft() {
        tl.moveLeft();
        br.moveLeft();
    }

    @Override
    public void moveRight() {
        tl.moveRight();
        br.moveRight();
    }

    @Override
    public String toString() {
        return "MovableRectangle {" +
                "tl=" + tl +
                ", br=" + br +
                '}';
    }
}
