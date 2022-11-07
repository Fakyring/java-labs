package Task2;

public abstract class AbstractQueue<E> implements Queue<E> {
    protected int size;

    public E element() {
        assert size > 0;
        return getElement();
    }

    public boolean push(E element) {
        assert element != null;
        pushElem(element);
        size++;
        return true;
    }

    public E pop() {
        assert size > 0;
        E result = element();
        size--;
        remove();
        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    protected abstract void pushElem(E element);

    protected abstract void remove();

    protected abstract E getElement();
}