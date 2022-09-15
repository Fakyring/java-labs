package T3;

import T1_2.Circle;
import T1_2.Rectangle;
import T1_2.Shape;
import T1_2.Square;

public class Task_3 {
    public static void main(String[] args) {
        //Преобразование подкласса в родительский класс
        Shape s1 = new Circle(5.5, "RED", false);
        System.out.println(s1);
        System.out.println(s1.getArea());
        System.out.println(s1.getPerimeter());
        System.out.println(s1.getColor());
        System.out.println(s1.isFilled());
        //Нет доступа к методу внутри класса Circle, так как создан объект класса Shape
        //System.out.println(s1.getRadius());
        //Создаём новый объект класса Circle и, меняя класс у переменной s1, присваиваем её новому объекту
        Circle c1 = (Circle)s1;
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.isFilled());
        System.out.println(c1.getRadius()); //Теперь радиус выводится
        //Shape s2 = new Shape(); //Невозможно создать абстрактный класс
        //Преобразование подкласса в родительский класс
        Shape s3 = new Rectangle(1.0, 2.0, "RED", false);
        System.out.println(s3);
        System.out.println(s3.getArea());
        System.out.println(s3.getPerimeter());
        System.out.println(s3.getColor());
        //System.out.println(s3.getHeight()); //Нет доступа к методу подкласса
        Rectangle r1 = (Rectangle)s3; //Преобразуем родительский класс в подкласс
        System.out.println(r1);
        System.out.println(r1.getArea());
        System.out.println(r1.getColor());
        System.out.println(r1.getHeight()); //Появился доступ к методу подкласса
        Shape s4 = new Square(6.6); //Преобразование под-подкласса в родительский класс
        System.out.println(s4);
        System.out.println(s4.getArea());
        System.out.println(s4.getColor());
        //System.out.println(s4.getSide()); //Нет доступа к методу подкласса
        Rectangle r2 = (Rectangle)s4; //Преобразуем родительский класс в подкласс
        System.out.println(r2);
        System.out.println(r2.getArea());
        System.out.println(r2.getColor());
        //System.out.println(r2.getSide()); //Доступа к методу класса Square до сих пор нет!
        System.out.println(r2.getHeight());
        Square sq1 = (Square)r2; //Преобразуем класса Rectangle в Square
        System.out.println(sq1);
        System.out.println(sq1.getArea());
        System.out.println(sq1.getColor());
        System.out.println(sq1.getSide()); //Появился доступ к методу подкласса
        System.out.println(sq1.getHeight()); //Остался доступ к методу род. класса
    }
}