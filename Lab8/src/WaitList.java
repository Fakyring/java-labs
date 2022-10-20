import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Лист ожидания
 * @param <Enum>
 */
public class WaitList<Enum> implements IWaitList {
    protected ConcurrentLinkedQueue<Integer> content;

    public WaitList() {
        content = new ConcurrentLinkedQueue<>();
    }

    public WaitList(Collection<Integer> C) {
        content = new ConcurrentLinkedQueue<>(C);
    }

    @Override
    public void add(Object E) {
        content.add((Integer) E);
    }

    @Override
    public Enum remove() {
        Integer x = content.poll();
        return (Enum) x;
    }

    @Override
    public boolean contains(Object E) {
        return content.contains(E);
    }

    @Override
    public boolean containsAll(Collection C) {
        return content.containsAll(C);
    }

    @Override
    public boolean isEmpty() {
        return content.isEmpty();
    }

    @Override
    public String toString() {
        return "WaitList: " +
                "content = " + content;
    }
}
