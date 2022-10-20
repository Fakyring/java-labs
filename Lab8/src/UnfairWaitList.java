/**
 * Лист ожидания с возможностью удалить ожидающего
 * @param <Enum>
 */
public class UnfairWaitList<Enum> extends WaitList {
    public UnfairWaitList() {
    }

    public Enum remove() {
        return (Enum) super.remove();
    }

    public void moveToBack() {
        super.add(remove());
    }
}
