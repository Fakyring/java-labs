import java.util.Arrays;

public class InternetOrder implements Order {
    private int size;
    private ListNode head, tail;
    private Customer customer;

    public class ListNode {
        private ListNode next;
        private MenuItem value;
    }

    @Override
    public boolean add(MenuItem item) {
        ListNode tmp;
        if (size == 0) {
            head = new ListNode();
            tail = head;
            tmp = head;
        } else {
            tmp = tail;
            tail = new ListNode();
        }
        tmp.next = tail;
        tail.value = item;
        size++;
        return true;
    }

    @Override
    public String[] itemsName() {
        String[] names = new String[size];
        ListNode current = head;
        for (int i = 0; i < size; i++) {
            names[i] = current.value.getName();
            current = current.next;
        }
        return names;
    }

    @Override
    public int itemsQuantity() {
        return size;
    }

    @Override
    public int itemsQuantity(String name) {
        int count = 0;
        ListNode current = head;
        for (int i = 0; i < size; i++) {
            if (current.value.getName().equals(name))
                count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int count = 0;
        ListNode current = head;
        for (int i = 0; i < size; i++) {
            if (current.value.equals(item))
                count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public MenuItem[] getItems() {
        MenuItem[] menuItems = new MenuItem[size];
        ListNode current = head;
        for (int i = 0; i < size; i++) {
            menuItems[i] = current.value;
            current = current.next;
        }
        return menuItems;
    }

    @Override
    public boolean remove(String itemName) {
        boolean completion = false;
        if (head.value.getName().equals(itemName)) {
            completion = true;
            size--;
            head = head.next;
        } else {
            ListNode current = head;
            for (int i = 0; i < size - 1; i++) {
                assert current.next != null;
                if (current.next.value.getName().equals(itemName)) {
                    completion = true;
                    size--;
                    if (current.next == tail) {
                        tail = current;
                        current.next = null;
                    } else
                        current.next = current.next.next;
                    break;
                }
            }
        }
        return completion;
    }

    @Override
    public boolean remove(MenuItem item) {
        boolean completion = false;
        if (head.value.equals(item)) {
            completion = true;
            size--;
            head = head.next;
        } else {
            ListNode current = head;
            for (int i = 0; i < size - 1; i++) {
                assert current.next != null;
                if (current.next.value.equals(item)) {
                    completion = true;
                    size--;
                    if (current.next == tail) {
                        tail = current;
                        current.next = null;
                    } else
                        current.next = current.next.next;
                    break;
                }
            }
        }
        return completion;
    }

    @Override
    public int removeAll(String itemName) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            assert current.next != null;
            if (current.value.getName().equals(itemName)) {
                count++;
                size--;
                head = current.next;
                current = null;
                current = head;
                continue;
            }
            if (current.next == null)
                break;
            if (current.next.value.getName().equals(itemName)) {
                count++;
                size--;
                if (current.next == tail) {
                    tail = current;
                    current.next = null;
                } else
                    current.next = current.next.next;
            }
        }
        return count;
    }

    @Override
    public int removeAll(MenuItem item) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            assert current.next != null;
            if (current.value.equals(item)) {
                count++;
                size--;
                head = current.next;
                current = null;
                current = head;
                continue;
            }
            if (current.next == null)
                break;
            if (current.next.value.equals(item)) {
                count++;
                size--;
                if (current.next == tail) {
                    tail = current;
                    current.next = null;
                } else
                    current.next = current.next.next;
            }
        }
        return count;
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem[] menuItems = new MenuItem[size];
        ListNode current = head;
        for (int i = 0; i < size; i++) {
            menuItems[i] = current.value;
            current = current.next;
        }
        Arrays.sort(menuItems, new CostComparator());
        return menuItems;
    }

    @Override
    public int costTotal() {
        int cost = 0;
        ListNode current = head;
        for (int i = 0; i < size; i++) {
            cost += current.value.getCost();
            current = current.next;
        }
        return cost;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = new Customer(customer);
    }
}