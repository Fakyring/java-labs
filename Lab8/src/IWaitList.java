import java.util.Collection;

/**
 * Интерфейс листа ожидания
 * @param <Enum>
 */
public interface IWaitList<Enum>{
    /**
     * Добавить элемент
     * @param E
     */
    void add(Enum E);

    /**
     * Удалить головной элемент листа
     * @return
     */
    Enum remove();

    /**
     * Содержит ли лист элемент
     * @param E
     * @return
     */
    boolean contains(Enum E);

    /**
     * Содержит ли лист все элементы из другого листа
     * @param C
     * @return
     */
    boolean containsAll (Collection<Enum> C);

    /**
     * Возвращает значение пуст ли лист
     * @return
     */
    boolean isEmpty();
}
