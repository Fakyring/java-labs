import java.util.Scanner;

public class ThrowsDemo {
    //Task 5
    public void printMessage5(String key) {
        try {
            String message = getDetails5(key);
            System.out.println(message);
        } catch (NullPointerException e) {
            System.out.println("null");
        }
    }

    public String getDetails5(String key) {
        if (key == null) {
            throw new NullPointerException("null key in getDetails");
        }
        return "data for " + key;
    }

    //Task 6
    public void getKey6() throws Exception {
        Scanner myScanner = new Scanner(System.in);
        String key = myScanner.nextLine();
        printDetails6(key);
    }

    public void printDetails6(String key) throws Exception {
        try {
            String message = getDetails6(key);
            System.out.println(message);
        } catch (Exception e) {
            throw e;
        }
    }

    private String getDetails6(String key) throws Exception {
        if (key.equals("")) {
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }

    //Task 7
    public void getKey7() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter Key ");
        String key = myScanner.nextLine();
        try {
            printDetails7(key);
        } catch (Exception e) {
            getKey7();
        }
    }

    public void printDetails7(String key) throws Exception {
        String message = getDetails7(key);
        System.out.println(message);
    }

    private String getDetails7(String key) throws Exception {
        if (key.equals("")) {
            throw new Exception("Key set to empty string");
        }
        return "data for " + key;
    }

}