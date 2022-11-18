import java.util.Arrays;
import java.util.List;

public class ConvertToList {

    public <E> List<E> convert(E[] array) {
        return Arrays.asList(array);
    }

    public void test() {
        Integer[] integers = new Integer[]{1, 2, 3, 4, 5};
        String[] strings = new String[]{"first", "second", "third"};

        System.out.println(convert(integers));
        System.out.println(convert(strings));
    }
}