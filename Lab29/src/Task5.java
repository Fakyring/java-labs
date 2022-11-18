import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task5 {

    static private boolean isDate(int d, int m, int y) {
        int[] days = new int[]{31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean leap = (y % 4 == 0 && y % 100 != 0 || y % 400 == 0);
        if (leap && m == 2 && d > 29) {
            return false;
        }
        if (!leap && m == 2 && d > 28) {
            return false;
        }
        if (days[m - 1] < d && m != 2) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        String regEx = "^(([1-2][0-9])|(0[0-9])|(3[0-1]))/((1[0-2])|([1-9]))/((19[0-9]{2})|(2\\d{3}))";

        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(string);
        if (matcher.find()) {
            int[] date = new int[3];
            for (int i = 0; i < 3; i++)
                date[i] = Integer.parseInt(string.split("/")[i]);
            if (isDate(date[0], date[1], date[2])) {
                System.out.println("Date is correct");
            } else System.out.println("Date is incorrect");
        } else System.out.println("Date is written incorrectly");
    }
}
