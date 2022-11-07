package Task1;

public class ArrayQueueModuleTest {
    public static void fill() {
        for (int i = 0; i < 10; i++) {
            ArrayQueueModule.enqueue(i);
        }
    }

    public static void dump() {
        while (!ArrayQueueModule.isEmpty()) {
            System.out.println(ArrayQueueModule.toStringStat());
            System.out.println("size: " + ArrayQueueModule.size() + "\n" +
                    "element[0] = " + ArrayQueueModule.element() + "\n" +
                    "delete element[0]: " + ArrayQueueModule.dequeue() + "\n"
            );
        }
    }

    public static void main(String[] args) {
        fill();
        dump();
    }
}