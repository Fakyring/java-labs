package Task2;

public class LinkedQueue<E> extends AbstractQueue<E> {

    private class Node {
        private final E value;
        private Node next;

        public Node(E value, Node next) {
            assert value != null;

            this.value = value;
            this.next = next;
        }
    }

    private Node start;
    private Node end;

    protected void pushElem(E element) {
        if (start == null) {
            start = new Node(element, null);
            end = start;
        } else {
            Node node = new Node(element, null);
            end.next = node;
            end = node;
        }
    }

    @Override
    protected void remove() {
        if (size == 0) {
            start = null;
            end = null;
        } else {
            start = start.next;
        }
    }

    @Override
    protected E getElement() {
        return start.value;
    }

}