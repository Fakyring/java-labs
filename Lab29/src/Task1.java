import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = "A,B.C-D: E;F G";
        System.out.println("Before: " + string);
        System.out.print("Enter regex: ");
        String regex = scanner.nextLine();
        String[] arrayList = string.split(regex);

        System.out.print("After: ");
        for (String s : arrayList)
            System.out.print(s.strip() + " ");
    }
}
