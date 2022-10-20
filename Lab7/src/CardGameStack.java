import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CardGameStack {
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

        Stack<Integer> firstPlayer = new Stack<>();
        Stack<Integer> secondPlayer = new Stack<>();
        for (int i = 0; i < 5; i++) {
            firstPlayer.push(cards[i]);
            secondPlayer.push(cards[5 + i]);
        }
        System.out.println(firstPlayer);
        System.out.println(secondPlayer);
        while (counter < 106 && !firstPlayer.isEmpty() && !secondPlayer.isEmpty()) {
            if (firstPlayer.elementAt(0) < secondPlayer.elementAt(0)) {
                secondPlayer.push(firstPlayer.elementAt(0));
                secondPlayer.push(secondPlayer.elementAt(0));
            } else {
                firstPlayer.push(firstPlayer.elementAt(0));
                firstPlayer.push(secondPlayer.elementAt(0));
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
