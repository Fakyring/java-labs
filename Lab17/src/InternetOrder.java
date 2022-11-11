import java.util.ArrayList;
import java.util.Objects;

public class InternetOrder<Item> implements Order {

    // Класс узла списка
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

    // Метод добавления нового узла

    public boolean add(Item item) {
        if (first == null) {
            first = new Node(item);
            first.prev = first.next = first;
            last = first;
        }
        else {
            Node node = new Node(first, last, item);
            last.next = first.prev = node;
            first = node;
        }
        size++;
        return true;
    }

    // Проверка на пустоту списка
    private boolean isEmpty() {
        return this.size == 0;
    }

    // Удаление первого элемента списка
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


    @Override
    public boolean add(Item item) {
        if (first == null) {
            first = new Node((Item) item);
            first.prev = first.next = first;
            last = first;
        }
        else {
            Node node = new Node(first, last, (Item) item);
            last.next = first.prev = node;
            first = node;
        }
        size++;
        return true;
    }

    // Удаление элемента списка
    public boolean remove(String name) {
        boolean result = false;
        if (!isEmpty()) {
            if (Objects.equals(((Dish) this.first.value).getTitle(), name)) {
                removeFirst();
                result = true;
            } else {
                Node delete = null;
                for (Node node = this.first.next; node != this.first; node = node.next) {
                    if (Objects.equals(((Dish) node.value).getTitle(), name)) {
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

    // Проверка на наличие в списке
    private boolean contains(String name) {
        return indexOf(name) != -1;
    }

    // Полученеи индекса в списке
    private int indexOf(String name) {
        int index = -1;
        if (!isEmpty()) {
            if (Objects.equals(((Dish) this.first.value).getTitle(), name)) {
                index = 0;
            } else {
                int count = 1;
                for (Node node = this.first.next; node != this.first; node = node.next) {
                    if (Objects.equals(((Dish) node.value).getTitle(), name)) {
                        index = count;
                        break;
                    } else {
                        count++;
                    }
                }
            }
        }
        return index;
    }

    // Удаление всех элементов с переданным именем
    public int removeAll(String name) {
        Dish dish = new Dish(name, "");
        int count = 0;
        while (indexOf(name) != -1) {
            count++;
            remove(name);
        }
        return count;
    }

    // Общее количество элементов списка
    public int totalCount() {
        int count = 0;
        for (Node node = this.first.next; node != this.first; node = node.next) {
            count++;
        }
        return count;
    }

    // Общая цена элементов списка
    public int totalCost() {
        int cost = 0;
        for (Node node = this.first.next; node != this.first; node = node.next) {
            cost += ((Dish) node.value).getPrice();
        }
        return cost;
    }

    // Преобразвать список в массив
    public Item[] getArray() {
        ArrayList<Item> arrayList = new ArrayList<>();
        for (Node node = this.first.next; node != this.first; node = node.next) {
            arrayList.add(node.value);
        }
        return (Item[]) arrayList.toArray();
    }

    // Количество элементов списка с указанным именем
    public int numberOf(String name) {
        int count = 0;
        ArrayList<Item> arrayList = new ArrayList<>();
        for (Node node = this.first.next; node != this.first; node = node.next) {
            if (Objects.equals(((Dish) node.value).getTitle(), name)) count++;
        }
        return count;
    }

    // Массив из уникальных элементов списка
    public Item[] getUnicArray() {
        ArrayList<Item> arrayList = new ArrayList<>();
        for (Node node = this.first.next; node != this.first; node = node.next) {
            if (!arrayList.contains(node.value)) arrayList.add(node.value);
        }
        return (Item[]) arrayList.toArray();
    }

    // Массив элементов списка, отсортированных по убыванию цены
    @Override
    public Item[] getSortArray() {
        Item[] items = (Item[]) getArray();
        for (int i = 0; i < items.length - 1; i++) {
            for (int j = 0; j < items.length - 1; j++) {
                if (((Dish) items[j]).getPrice() > ((Dish) items[j + 1]).getPrice()) {
                    Item temp = items[j];
                    items[j] = items[j + 1];
                    items[j + 1] = temp;
                }
            }
        }
        return (Item[]) items;
    }

    InternetOrder() {}

    InternetOrder(Item[] items) {
        for (Item item : items) {
            add(item);
        }
    }
}