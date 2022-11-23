import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static boolean checkEmail(String str) {
        Matcher matcher = Pattern.compile("^[A-Z]+[A-Z0-9._%+-]*@[A-Z]+[A-Z0-9]*\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(str);
        return matcher.find();
    }

    static boolean checkPassword(String str) {
        Matcher mt1 = Pattern.compile("[0-9]").matcher(str);
        Matcher mt2 = Pattern.compile("[a-z]").matcher(str);
        Matcher mt3 = Pattern.compile("[A-Z]").matcher(str);
        return str.length() >= 8 && mt1.find() && mt2.find() && mt3.find();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data;
        System.out.print("Enter email: ");
        data = scanner.nextLine();
        System.out.println("Email is " + (checkEmail(data) ? "correct." : "incorrect."));

        System.out.print("Enter password: ");
        data = scanner.nextLine();
        System.out.println("Password is " + (checkPassword(data) ? "correct." : "incorrect."));
    }
}