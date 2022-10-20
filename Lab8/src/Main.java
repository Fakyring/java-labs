public class Main {
    public static void main(String[] args) {
        WaitList<Integer> clients = new WaitList<>();
        BoundedWaitList<Integer> bounded = new BoundedWaitList<>(5);
        UnfairWaitList<Integer> unfair = new UnfairWaitList<>();
        for (int i = 0; i < 10; i++) {
            clients.add(i);
            bounded.add(i);
            unfair.add(i);
        }
        unfair.moveToBack();
        System.out.println(clients);
        System.out.println(bounded);
        System.out.println(unfair);
    }
}