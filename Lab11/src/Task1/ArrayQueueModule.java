package Task1;

import java.util.Arrays;

public class ArrayQueueModule {
    private static int size;
    private static int[] elements = new int[5];

    public static void enqueue(int element) {
        ensureCapacity(size + 1);
        elements[size++] = element;
    }

    private static void ensureCapacity(int capacity) {
        if (capacity > elements.length) {
            elements = Arrays.copyOf(elements, 2 * capacity);
        }
    }

    public static int element() {
        assert size > 0;
        return elements[0];
    }

    public static int dequeue() {
        assert size > 0;
        int first = elements[0];
        for (int i = 1; i < size; i++)
            elements[i - 1] = elements[i];
        size--;
        return first;
    }

    public static int size() {
        return size;
    }

    public static boolean isEmpty() {
        return size == 0;
    }

    public static void clear() {
        elements = new int[0];
        size = 0;
    }

    public static String toStringStat() {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("[ ");
        for (int i = 0; i < size; i++) {
            stringBuffer.append(elements[i]).append(" ");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}