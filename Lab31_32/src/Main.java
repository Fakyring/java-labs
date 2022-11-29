import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InternetOrdersManager iom = new InternetOrdersManager();
        Order io = new InternetOrder();
        Customer customer = new Customer();

        //Creating internet orders
        MenuItem item = new Drink();
        io.add(item);
        item = new Drink("Some", "Descr", 200, 3, 7);
        io.add(item);
        item = new Drink();
        io.add(item);
        io.setCustomer(customer);

        //Adding orders to manager (из менеджеров лучше расписан настольный менеджер, он ниже будет)
        iom.add(io);
        iom.add(io);
        iom.add(io);
        iom.add(io);
        iom.remove();
        System.out.println(Arrays.toString(iom.getOrder()));


        System.out.println(Arrays.toString(io.itemsName())); //Prints names of items from last order
        System.out.println(io.itemsQuantity("Name")); //Count items with specific name
        System.out.println(io.itemsQuantity(item)); //Count specific items
        io.removeAll("Name"); //Remove all items by name
        System.out.println(Arrays.toString(io.itemsName())); //Print all items' names
        System.out.println(io.getCustomer().getFirstName()); //Get name of the customer
        System.out.println();

        //----------------------Table orders part of program----------------------
        System.out.println("Table orders:");
        TableOrdersManager tom = new TableOrdersManager();
        Order to = new TableOrder();
        //Creating table orders
        item = new Drink();
        to.add(item);
        item = new Drink("Some", "Descr", 200, 3, 7);
        to.add(item);
        item = new Drink();
        to.add(item);
        tom.add(to, 3);
        tom.add(to, 4);

        System.out.println("Free tables: " + tom.freeTableNumber()); //Get total amount of free tables
        System.out.println("Free tables number: " + Arrays.toString(tom.freeTableNumbers())); //Get all free tables numbers
        System.out.println("Total cost of orders: " + tom.ordersCostSummary()); //Get total cost of all orders

        System.out.println(Arrays.toString(to.itemsName())); //Prints items' names
        MenuItem[] mi = to.sortedItemsByCostDesc(); //Gets sorted array
        System.out.print("Sorted items costs: ");
        for (int i = 0; i < mi.length; i++) {
            System.out.print(mi[i].getCost() + " "); //Print sorted array
        }
        System.out.println();
        to.remove("Name"); //Remove first element by its name
        System.out.println(Arrays.toString(to.itemsName()));
        to.removeAll("Name"); //Remove all element with given name
        System.out.println(Arrays.toString(to.itemsName()));

    }
}