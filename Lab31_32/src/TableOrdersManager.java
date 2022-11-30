import java.util.Arrays;

public class TableOrdersManager implements OrdersManager {
    private Order[] orders = new TableOrder[0];

    private void increaseArray(int tableNumber) {
        orders = Arrays.copyOf(orders, tableNumber + 1);
    }

    public void add(Order order, int tableNumber) {
        if (tableNumber >= orders.length)
            increaseArray(tableNumber);
        orders[tableNumber] = order;
    }

    public void addItem(MenuItem item, int tableNumber) {
        if (tableNumber >= orders.length)
            increaseArray(tableNumber);
        if (orders[tableNumber] != null) {
            orders[tableNumber].add(item);
        } else {
            Order order = new TableOrder();
            order.add(item);
            add(order, tableNumber);
        }
    }

    public int freeTableNumber() {
        int count = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null)
                count++;
        }
        return count;
    }

    public int[] freeTableNumbers() {
        int[] tables = new int[orders.length];
        int counter = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) {
                tables[counter] = i;
                counter++;
            }
        }
        tables = Arrays.copyOf(tables, counter);
        return tables;
    }

    public Order getOrder(int tableNumber) {
        return orders[tableNumber];
    }

    public void remove(int tableNumber) {
        orders[tableNumber] = null;
    }

    public int remove(Order order) {
        int count = 0;
        for (int i = 0; i < orders.length; i++) {
            count++;
            if (orders[i] == order) {
                orders[i] = null;
                break;
            }
        }
        return count;
    }

    public int removeAll(Order order) {
        int count = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == order) {
                orders[i] = null;
                count++;
            }
        }
        return count;
    }

    @Override
    public int itemsQuantity(String itemName) {
        int count = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] != null)
                count += orders[i].itemsQuantity(itemName);
        }
        return count;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int count = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] != null)
                count += orders[i].itemsQuantity(item);
        }
        return count;
    }

    @Override
    public Order[] getOrder() {
        return orders;
    }

    @Override
    public int ordersCostSummary() {
        int count = 0;
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] != null) {
                count += orders[i].costTotal();
            }
        }
        return count;
    }

    @Override
    public int ordersQuantity() {
        return orders.length;
    }
}
