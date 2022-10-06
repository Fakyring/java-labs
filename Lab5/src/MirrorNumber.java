import java.util.Scanner;

public class MirrorNumber {
    public static int mirrorNumb(int n, int a) {
        if (n == 0) {
            return a;
        }
        return mirrorNumb(n / 10, a * 10 + n % 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n = mirrorNumb(n, 0);
        System.out.println(n);
    }
}