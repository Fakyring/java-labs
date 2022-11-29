public class InternetOrder<Item> {

    InternetOrder() {
    }

    InternetOrder(Item[] items) {
        for (Item item : items) {
            add(item);
        }
    }

    private class Node {
        private Node next;
        private Node prev;
        private Item value;

        Node(Node next, Node prev, Item value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }

        Node(Item value) {
            this(null, null, value);
        }
    }

    private Node first;
    private Node last;
    private int size;

    //Creating node
    public boolean add(Item item) {
        if (first == null) {
            first = new Node(item);
            first.prev = first.next = first;
            last = first;
        } else {
            Node node = new Node(first, last, item);
            last.next = first.prev = node;
            first = node;
        }
        size++;
        return true;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    private Item removeFirst() {
        Item oldElement;
        if (this.size == 1) {
            oldElement = this.first.value;
        } else {
            oldElement = this.first.value;
            Node newFirst = this.first.next;
            newFirst.prev = this.last;
            this.last.next = newFirst;
            this.first = newFirst;
            this.size--;
        }
        return oldElement;
    }

    private Item removeLast() {
        Item oldElement;
        if (this.size == 1) {
            oldElement = this.first.value;
        } else {
            oldElement = this.last.value;
            Node newLast = this.last.prev;
            newLast.next = this.first;
            this.first.prev = newLast;
            this.last = newLast;
            this.size--;
        }
        return oldElement;
    }

    //Remove element by name
    public boolean remove(String name) {
        boolean result = false;
        if (!isEmpty()) {
            if (((Dish) convertToDish(this.first.value)).getTitle().equals(name)) {
                removeFirst();
                result = true;
            } else {
                Node delete = null;
                for (Node node = this.first.next; node != this.first; node = node.next) {
                    if (((Dish) convertToDish(node.value)).getTitle().equals(name)) {
                        delete = node;
                    }
                }
                if (delete != null) {
                    if (delete == this.last) {
                        removeLast();
                        result = true;
                    } else {
                        delete.prev.next = delete.next;
                        delete.next.prev = delete.prev;
                        this.size--;
                        result = true;
                    }
                }
            }
        }
        return result;
    }

    //Searching element with given name
    private boolean indexOf(String name) {
        boolean result = false;
        if (!isEmpty()) {
            if (((Dish) convertToDish(this.first.value)).getTitle().equals(name)) {
                result = true;
            } else {
                int count = 1;
                for (Node node = this.first.next; node != this.first; node = node.next) {
                    if (((Dish) convertToDish(node.value)).getTitle().equals(name)) {
                        result = true;
                        break;
                    } else {
                        count++;
                    }
                }
            }
        }
        return result;
    }

    //Remove all elements with given name
    public int removeAll(String name) {
        Dish dish = new Dish(name, "");
        int count = 0;
        while (indexOf(name)) {
            count++;
            remove(name);
        }
        return count;
    }

    public int totalCount() {
        int count = 0;
        for (Node node = this.first.next; node != this.first; node = node.next) {
            count++;
        }
        return count;
    }

    public int totalCost() {
        int cost = 0;
        for (Node node = this.first.next; node != this.first; node = node.next) {
            cost += ((Dish) convertToDish(node.value)).getPrice();
        }
        return cost;
    }

    private Item convertToDish(Item item) {
        Dish dish;
        if (item.getClass().equals(Drink.class)) {
            dish = new Dish(((Drink) item).getTitle(), ((Drink) item).getDescription(), ((Drink) item).getPrice());
        } else {
            dish = new Dish(((Dish) item).getTitle(), ((Dish) item).getDescription(), ((Dish) item).getPrice());
        }
        return (Item) dish;
    }

    //Convert list to array
    public Item[] getArray() {
        Item[] items = (Item[]) new Dish[size];
        int i = 0;
        items[i] = convertToDish(first.value);
        for (Node node = this.first.next; node != this.first; node = node.next) {
            i++;
            items[i] = convertToDish(node.value);
        }
        return items;
    }

    //Gets amount of elements with given name
    public int numberOf(String name) {
        int count = 0;
        if (((Dish) convertToDish(this.first.value)).getTitle().equals(name)) count++;
        for (Node node = this.first.next; node != this.first; node = node.next) {
            if (((Dish) convertToDish(node.value)).getTitle().equals(name)) count++;
        }
        return count;
    }

    //Get array with unique elements
    public Item[] getUniqueArray() {

        Item[] items = (Item[]) new Dish[size];
        int i = 0;
        items[i] = convertToDish(first.value);
        i++;
        boolean unique;
        for (Node node = this.first.next; node != this.first; node = node.next) {
            unique = true;
            for (int j = 0; j < i; j++) {
                if (((Dish) items[j]).getTitle() == ((Dish) convertToDish(node.value)).getTitle() &&
                        ((Dish) items[j]).getDescription() == ((Dish) convertToDish(node.value)).getDescription() &&
                        ((Dish) items[j]).getPrice() == ((Dish) convertToDish(node.value)).getPrice()) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                items[i] = convertToDish(node.value);
                i++;
            }
        }
        return items;
    }

    //Get sorted array
    public Item[] getSortArray() {
        Item[] items = getArray();
        for (int i = 0; i < items.length - 1; i++) {
            for (int j = 0; j < items.length - 1; j++) {
                if (((Dish) items[j]).getPrice() > ((Dish) items[j + 1]).getPrice()) {
                    Item temp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                }
            }
        }
        return items;
    }
}