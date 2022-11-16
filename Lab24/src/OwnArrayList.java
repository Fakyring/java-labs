import java.util.AbstractList;

public class OwnArrayList<T> {
    private int size = 0;
    private Object[] array = new Object[10];

    public void add(Object item) {
        if (size == array.length - 1) {
            resize(array.length * 2);
        }
        array[size++] = item;
    }

    private void resize(int capacity) {
        Object[] newArray = new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public void remove(int index) {
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        array[size] = null;
        size--;
        if (array.length / 2 < size) {
            resize(array.length / 2);
        }
    }

    public Object get(int index) {
        return (T) array[index];
    }

    public int size() {
        return size;
    }
}