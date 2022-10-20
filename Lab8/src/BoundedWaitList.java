import java.util.Collection;

/**
 * Ограниченный лист ожидания
 * @param <Enum>
 */
public class BoundedWaitList<Enum> extends WaitList {
    private final int capacity;

    public BoundedWaitList(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Integer element) {
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