import java.util.*;

public class CardGameDoubleList{
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

        LinkedList<Integer> firstPlayer = new LinkedList<>();
        LinkedList<Integer> secondPlayer = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            firstPlayer.add(cards[i]);
            secondPlayer.add(cards[i + 5]);
        }
        System.out.println(firstPlayer);
        System.out.println(secondPlayer);
        while (counter < 106 && !firstPlayer.isEmpty() && !secondPlayer.isEmpty()) {
            if (firstPlayer.get(0) < secondPlayer.get(0)) {
                secondPlayer.add(firstPlayer.get(0));
                secondPlayer.add(secondPlayer.get(0));
            } else {
                firstPlayer.add(firstPlayer.get(0));
                firstPlayer.add(secondPlayer.get(0));
            }
            firstPlayer.remove(0);
            secondPlayer.remove(0);
            counter++;
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
