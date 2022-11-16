public class Main {

    public static void main(String[] args) {
        OwnArrayList<Integer> arrayList = new OwnArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
        }
        System.out.println("Adding: ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
        arrayList.remove(7);
        System.out.println("\nDeleting: ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }
    }
}