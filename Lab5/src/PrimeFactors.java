import java.util.Scanner;

public class PrimeFactors {
    public static int GetPrimes(int n, int i) {
        try {
            if (n % i == 0) {
                if (isPrime(i, 2)) {
                    System.out.println(i);
                }
            }
            if (i <= n) {
                return GetPrimes(n, i + 1);
            } else {
                return 1;
            }
        } catch (java.lang.StackOverflowError e) {
            return 0;
        }
    }

    public static boolean isPrime(int n, int i) {
        if (n <= 2)
            return (n == 2);
        if (n % i == 0)
            return false;
        if (i * i > n)
            return true;
        return isPrime(n, i + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Введите число (n > 2): ");
        n = sc.nextInt();
        if (n > 1) {
            System.out.println("Простые числа: ");
            if (GetPrimes(n, 2) == 0) {
                System.out.println("Стак переполнился");
            }
        } else {
            System.out.println("Число меньше 2");
        }
    }
}
