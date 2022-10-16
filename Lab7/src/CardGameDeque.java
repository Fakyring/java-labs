import java.util.*;

public class CardGameDeque{
    public static void main(String[] args) {
        int counter = 0;
        //Available cards
        Integer[] cards = new Integer[10];
        for (int i = 0; i < 10; i++) {
            cards[i] = i;
        }
        List<Integer> intList = Arrays.asList(cards);
        Collections.shuffle(intList);
        intList.toArray(cards);

        Deque<Integer> firstPlayer = new LinkedList<>();
        Deque<Integer> secondPlayer = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            firstPlayer.add(cards[i]);
            secondPlayer.add(cards[i + 5]);
        }
        System.out.println(firstPlayer);
        System.out.println(secondPlayer);
        while (counter < 106 && !firstPlayer.isEmpty() && !secondPlayer.isEmpty()) {
            if (firstPlayer.peek() < secondPlayer.peek()) {
                secondPlayer.add(firstPlayer.peek());
                secondPlayer.add(secondPlayer.peek());
            } else {
                firstPlayer.add(firstPlayer.peek());
                firstPlayer.add(secondPlayer.peek());
            }
            firstPlayer.remove();
            secondPlayer.remove();
            counter++;
//            System.out.println("Step " + counter);
//            System.out.println(firstPlayer);
//            System.out.println(secondPlayer);
        }
        if (counter == 106) {
            System.out.println("Botva");
        } else {
            if (firstPlayer.isEmpty()) {
                System.out.println("second " + counter);
            } else {
                System.out.println("first " + counter);
            }
        }
    }
}
