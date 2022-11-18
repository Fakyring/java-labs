import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void readFirstFive(String path) {
        File file = new File(path);
        String[] files = null;
        if (file.exists() || file.isDirectory())
            files = file.list();
        else
            System.out.print("Directory is not available");
        ArrayList list = new ArrayList(Arrays.asList(files));
        for (int i = 0; i < list.size() && i < 5; i++)
            System.out.println(list.get(i));
    }

    public static void main(String[] args) {
        readFirstFive("C:\\");
    }
}