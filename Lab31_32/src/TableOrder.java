import java.util.Arrays;
import java.util.Comparator;

public class TableOrder implements Order {
    private int size;
    private MenuItem[] items = new MenuItem[0];
    Customer customer;

    private void increaseArray() {
        items = Arrays.copyOf(items, size * 2);
    }

    @Override
    public boolean add(MenuItem item) {
        size++;
        if (items.length >= size - 2 || items.length == 0)
            increaseArray();
        for (int i = 0; i < size; i++) {
            if (items[i] == null) {
                items[i] = item;
                break;
            }
        }
        return true;
    }

    @Override
    public String[] itemsName() {
        String[] names = new String[size];
        for (int i = 0; i < size; i++) {
            names[i] = items[i].getName();
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
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(name))
                count++;
        }
        return count;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item))
                count++;
        }
        return count;
    }

    @Override
    public MenuItem[] getItems() {
        return items;
    }

    @Override
    public boolean remove(String itemName) {
        boolean completion = false;
        for (int i = 0; i < size - 1; i++) {
            if (items[i].getName().equals(itemName)) {
                completion = true;
                for (int j = i; j < size; j++) {
                    items[j] = items[j + 1];
                }
                items[size - 1] = null;
                size--;
                break;
            }
        }
        return completion;
    }

    @Override
    public boolean remove(MenuItem item) {
        boolean completion = false;
        for (int i = 0; i < size - 1; i++) {
            if (items[i].equals(item)) {
                completion = true;
                for (int j = i; j < size; j++) {
                    items[j] = items[j + 1];
                }
                items[size - 1] = null;
                size--;
                break;
            }
        }
        return completion;
    }

    @Override
    public int removeAll(String itemName) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(itemName)) {
                count++;
                for (int j = i; j < size; j++) {
                    items[j] = items[j + 1];
                }
                items[size - 1] = null;
                i--;
                size--;
            }
        }
        return count;
    }

    @Override
    public int removeAll(MenuItem item) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].equals(item)) {
                count++;
                for (int j = i; j < size; j++) {
                    items[j] = items[j + 1];
                }
                items[size - 1] = null;
                i--;
                size--;
            }
        }
        return count;
    }

    @Override
    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem[] menuItems = Arrays.copyOf(items, size);
        Arrays.sort(menuItems, new CostComparator());
        return menuItems;
    }

    @Override
    public int costTotal() {
        int cost = 0;
        for (int i = 0; i < size; i++) {
            cost += items[i].getCost();
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

    public int getSize() {
        return size;
    }
}

class CostComparator implements Comparator<MenuItem> {
    @Override
    public int compare(MenuItem a, MenuItem b) {
        return (int) (b.getCost() - a.getCost());
    }
}
