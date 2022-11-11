import java.util.Objects;

public class RestaurantOrder implements Order{
    private Item[] items;
    private int capacity;
    private int size = 0;

    public RestaurantOrder(int capacity) {
        this.capacity = capacity;
        items = new Item[capacity];
    }

    public Item getItem(int index){
        try {
            return items[index];
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Out of bounds");
        }
        return null;
    }

    public int size(){
        return size;
    }

    private void copy(int newCapacity){
        Item[] newItems = new Item[newCapacity];
        if (size >= 0) System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }


    @Override
    public boolean add(Item item) {
        if (size == capacity - 1){
            capacity *= 2;
            copy(capacity);
        }
        items[size] = item;
        size+=1;
        return true;
    }

    @Override
    public boolean remove(String name) {
        for (int i = 0; i < size - 2; i++)
            if (Objects.equals(items[i].getTitle(), name))
                for (int j = i; j < size - 2; j++) {
                    items[j] = items[j + 1];
                    size -= 1;
                    return true;
                }
        if (Objects.equals(items[size - 1].getTitle(), name)) {
            items[size - 1] = null;
            return true;
        }
        return false;
    }

    @Override
    public int removeAll(String name) {
        int s = 0;
        boolean f = true;
        do {
            f = false;
            for (int i = 0; i < size - 1; i++) {
                if (Objects.equals(items[i].getTitle(), name)) {
                    f = true;
                    remove(name);
                    size--;
                    s++;
                }
            }
        } while (f);
        return s;
    }

    @Override
    public int totalCount() {
        return size;
    }

    @Override
    public Item[] getArray() {
        return items;
    }

    @Override
    public int totalCost() {
        int s = 0;
        for (int i = 0; i < items.length; i++) {
            s += items[i].getPrice();
        }
        return s;
    }

    @Override
    public int numberOf(String name) {
        int s = 0;
        for (Item item : items) {
            if (Objects.equals(item.getTitle(), name)) s++;
        }
        return s;
    }

    @Override
    public Item[] getUnicArray() {
        int k = 0;
        Item[] temp = new Item[capacity];
        for (int i = 0; i < size - 2; i++) {
            boolean f = false;
            for (int j = i + 1; j < size - 1; j++) {
                if (items[i] == items[j]) {
                    f = true;
                    break;
                }
            }
            if (!f) {
                temp[k] = items[i];
                k++;
            }
        }
        return temp;
    }

    @Override
    public Item[] getSortArray() {
        return new Item[0];
    }
}