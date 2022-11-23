public class Main {
    public static void displayArray(InternetOrder<Item> internetOrder) {
        Item[] items = internetOrder.getArray();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i].getTitle() + " " + items[i].getDescription() + " " + items[i].getPrice());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        InternetOrder<Item> internetOrder = new InternetOrder<Item>();
        Item item = new Dish("First", "text", 2000);
        internetOrder.add(item);
        item = new Dish("Second", "another text", 1500);
        internetOrder.add(item);
        item = new Drink("Mojito", "another text", 3000);
        internetOrder.add(item);
        item = new Dish("Second", "another text", 1500);
        internetOrder.add(item);
        internetOrder.add(item);
        System.out.println("Number of: " + internetOrder.numberOf("Second"));
        System.out.println("Total cost: " + internetOrder.totalCost());
        System.out.println("Unique array");
        Item[] items = internetOrder.getUniqueArray();
        for (int i = 0; i < items.length && items[i] != null; i++) {
            System.out.println(items[i].getTitle() + " " + items[i].getDescription() + " " + items[i].getPrice());
        }

        System.out.println("\nSorted array");
        items = internetOrder.getSortArray();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i].getTitle() + " " + items[i].getDescription() + " " + items[i].getPrice());
        }
        System.out.println("\nSimple array");
        displayArray(internetOrder);

        System.out.println("\nRemoving one");
        internetOrder.remove("Second");
        displayArray(internetOrder);

        System.out.println("Removing all");
        internetOrder.removeAll("Second");
        displayArray(internetOrder);
    }
}