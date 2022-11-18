public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Task 1");
        Exception1 excep1 = new Exception1();
        //excep1.exceptionDemo(); //1.1
        excep1.exceptionDemo1(); //1.2

        System.out.println("Tasks 2-4");
        Exception2 excep2 = new Exception2();
        excep2.exceptionDemo(); //2-4

        System.out.println("Task 5");
        ThrowsDemo td = new ThrowsDemo();
        td.printMessage5("Correct key"); //5
        td.printMessage5(null);

        System.out.println("Task 6-7");
        td.getKey7(); //6(7)
    }
}
