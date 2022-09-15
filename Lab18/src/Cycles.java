import java.util.Scanner;

public class Cycles {
    public static void main(String[] args) {
        int n, summ = 0, i;
        System.out.print("Enter array size: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] a = new int[n];
        for (i = 0; i < n; i++) {
            System.out.print(i + ": ");
            a[i] = sc.nextInt();
        }
        System.out.println("For: ");
        for (i = 0; i < n; i++) {
            summ += a[i];
        }
        System.out.println(summ);
        summ = 0;
        i = 0;
        System.out.println("While: ");
        while (i < n) {
            summ += a[i];
            i++;
        }
        System.out.println(summ);
        summ = 0;
        i = 0;
        System.out.println("Do While: ");
        do {
            summ += a[i];
            i++;
        } while (i < n);
        System.out.println(summ);
    }
}
