public interface Order {
    public boolean add(MenuItem item);
    public String[] itemsName();
    public int itemsQuantity();
    public int itemsQuantity(String name);
    public int itemsQuantity(MenuItem item);
    public MenuItem[] getItems();
    public boolean remove(String itemName);
    public boolean remove(MenuItem item);
    public int removeAll(String itemName);
    public int removeAll(MenuItem item);
    public MenuItem[] sortedItemsByCostDesc();
    public int costTotal();
    public Customer getCustomer();
    public void setCustomer(Customer customer);
}