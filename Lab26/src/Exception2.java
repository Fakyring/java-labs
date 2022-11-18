import java.util.Scanner;

public class Exception2 {
    public void exceptionDemo() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter an integer ");
        String intString = myScanner.next();
        int i = Integer.parseInt(intString);
        try {
            System.out.println(2 / i);
        } catch (Exception e) {
            System.out.println("Division by zero");
        }
        finally {
            System.out.println("Alles ist gut");
        }
    }
}