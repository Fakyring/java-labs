package Task2;

public interface Queue<E> {
    E element();

    boolean push(E elem);

    E pop();

    int size();

    boolean isEmpty();
}