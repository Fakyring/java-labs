import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "abcdefghijklmnopqrstuv18340";
        System.out.print("Enter the string: ");
        String string = scanner.nextLine();
        System.out.print("Matches: ");
        System.out.println(string.matches(regex));
        System.out.print("Enter the string: ");
        string = scanner.nextLine();
        System.out.print("Matches: ");
        System.out.println(string.matches(regex));
    }
}
