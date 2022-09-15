import java.util.Scanner;

public class Fact {
    public static void main(String[] args) {
        int n, summ = 1;
        System.out.print("Enter number: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            summ *= i;
        }
        System.out.println(n + "! = " + summ);
    }
}