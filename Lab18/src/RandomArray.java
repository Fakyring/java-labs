import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RandomArray {
    public static void main(String[] args) {
        int n;
        System.out.print("Enter array size: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Random rn = new Random();
        int[] a = new int[n];
        System.out.println("Original");
        for (int i = 0; i < n; i++) {
            a[i] = rn.nextInt(1, 30);
            System.out.println(a[i]);
        }
        Arrays.sort(a);
        System.out.println("Sorted");
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }
}
