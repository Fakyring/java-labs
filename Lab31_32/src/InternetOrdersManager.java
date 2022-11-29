public class InternetOrdersManager implements OrdersManager {
    private QueueNode head, tail;
    private int size;

    private class QueueNode {
        private QueueNode next, prev;
        private Order value;
    }

    public boolean add(Order order) {
        QueueNode newNode;
        if (size == 0) {
            head = new QueueNode();
            tail = head;
            head.value = order;
            head.next = head.prev = head;
        } else {
            newNode = new QueueNode();
            newNode.value = order;
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    public Order remove() {
        QueueNode tmp = head;
        if (head.next != null)
            head.next.prev = head.next;
        head = head.next;
        size--;
        return tmp.value;
    }

    public Order order() {
        return head.value;
    }

    @Override
    public int itemsQuantity(String itemName) {
        int count = 0;
        QueueNode current = head;
        for (int i = 0; i < size; i++) {
            count += current.value.itemsQuantity(itemName);
            current = current.next;
        }
        return count;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int count = 0;
        QueueNode current = head;
        for (int i = 0; i < size; i++) {
            count += current.value.itemsQuantity(item);
            current = current.next;
        }
        return count;
    }

    @Override
    public Order[] getOrder() {
        Order[] orders = new Order[size];
        QueueNode current = head;
        for (int i = 0; i < size; i++) {
            orders[i] = current.value;
            current = current.next;
        }
        return orders;
    }

    @Override
    public int ordersCostSummary() {
        int count = 0;
        QueueNode current = head;
        for (int i = 0; i < size; i++) {
            count += current.value.costTotal();
            current = current.next;
        }
        return count;
    }

    @Override
    public int ordersQuantity() {
        return size;
    }
}
