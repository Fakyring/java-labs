package Task2;

public class QueueTests {
    public static void fill(Queue queue) {
        for (int i = 0; i < 3; i++) {
            queue.push(i);
        }
    }

    public static void dump(Queue queue) {
        while (!queue.isEmpty()) {
            System.out.println("Size: " + queue.size() + "; First: " +
                    queue.element() + "; Removing: " + queue.pop());
        }
    }

    public static void test(Queue queue) {
        fill(queue);
        dump(queue);
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Array");
        test(new ArrayQueue<Integer>());
        System.out.println("Linked");
        test(new LinkedQueue<Integer>());
    }
}