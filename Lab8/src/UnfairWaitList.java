/**
 * Лист ожидания с возможностью удалить ожидающего
 * @param <E>
 */
public class UnfairWaitList<E> extends WaitList<E> {
    public UnfairWaitList() {
    }

    public E remove() {
        return super.remove();
    }

    public void moveToBack() {
        super.add(remove());
    }
}
