public interface OrdersManager {
    public int itemsQuantity(String itemName);
    public int itemsQuantity(MenuItem item);
    public Order[] getOrder();
    public int ordersCostSummary();
    public int ordersQuantity();
}
