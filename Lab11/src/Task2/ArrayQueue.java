package Task2;

import java.util.ArrayList;

public class ArrayQueue<E> extends AbstractQueue<E> {
    private final ArrayList<E> elements = new ArrayList<>();

    @Override
    protected void pushElem(E element) {
        elements.add(element);
    }

    @Override
    protected void remove() {
        elements.remove(0);
    }

    @Override
    protected E getElement() {
        return elements.get(0);
    }
}