import java.util.Scanner;

public class Palindrome {
    public static boolean isPalindrome(String s, int len, int i) {
        if (i >= len / 2)
            return true;
        if (s.charAt(i) != s.charAt(len - i - 1))
            return false;
        return isPalindrome(s, len, i + 1);
    }

    public static void main(String[] args) {
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите строку: ");
        s = sc.next();
        if (isPalindrome(s.toLowerCase(), s.length(), 0)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
