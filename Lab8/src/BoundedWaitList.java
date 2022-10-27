import java.util.Collection;

/**
 * Ограниченный лист ожидания
 * @param <E>
 */
public class BoundedWaitList<E> extends WaitList<E> {
    private final int capacity;

    public BoundedWaitList(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(E element) {
        if (content.size() < capacity)
            super.add(element);
    }

    @Override
    public String toString() {
        return "BoundedWaitList: " +
                "capacity = " + capacity +
                ", content = " + content;
    }
}