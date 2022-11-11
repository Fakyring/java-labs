import java.util.GregorianCalendar;
import java.util.HashMap;

public class OrderManager {
    private RestaurantOrder[] orders;
    private int capacity;
    private int size = 0;
    private HashMap<String , RestaurantOrder> hashMap = new HashMap<>();

    public OrderManager(int capacity) {
        this.capacity = capacity;
        orders = new RestaurantOrder[capacity];
    }

    public void addOrder(RestaurantOrder order){
        if (size == capacity - 1){
            capacity *= 2;
            copy(capacity);
        }
        orders[size] = order;
        size+=1;
    }

    public RestaurantOrder getOrder(int index) {
        try {
            return orders[index];
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Out of bounds");
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    private void copy(int newCapacity){
        RestaurantOrder[] newOrders = new RestaurantOrder[newCapacity];
        if (size >= 0) System.arraycopy(orders, 0, newOrders, 0, size);
        orders = newOrders;
    }

    public void remove(RestaurantOrder order) {
        for (int i = 0; i < size; i++)
            if (orders[i] == order)
                for (int j = i; j < size; j++)
                    orders[j] = orders[j - 1];

        size -= 1;
    }

    public boolean addHash(String address, RestaurantOrder restaurantOrder) {
        hashMap.put(address, restaurantOrder);
        return true;
    }

    public Order getHash(String address) {
        return hashMap.get(address);
    }

    public boolean removeHash(String address) {
        hashMap.remove(address);
        return true;
    }

    public boolean addItemHash(String string, Item item) {
        RestaurantOrder restaurantOrder = new RestaurantOrder(1);
        restaurantOrder.add(item);
        hashMap.put(string, restaurantOrder);
        return true;
    }

    public RestaurantOrder[] getArrayHash() {
        int i = 0;
        RestaurantOrder[] restaurantOrders = new RestaurantOrder[hashMap.size()];
        for (RestaurantOrder restaurantOrder : hashMap.values()) {
            restaurantOrders[i] = restaurantOrder;
            i++;
        }
        return restaurantOrders;
    }

    public int totalCost() {
        int s = 0;
        RestaurantOrder[] restaurantOrders = getArrayHash();
        for (int i = 0; i < restaurantOrders.length; i++) {
            s += restaurantOrders[i].totalCost();
        }
        return s;
    }

    public int getCountHash(Item item) {
        int s = 0;
        Order[] orders = getArrayHash();
        for(int i = 0; i < orders.length; i++) {
            s += orders[i].numberOf(item.getTitle());
        }
        return s;
    }

}