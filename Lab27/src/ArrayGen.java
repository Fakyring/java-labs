import java.util.Arrays;

public class ArrayGen<E> {
    private E[] elements;

    public ArrayGen() {
    }

    public ArrayGen(E[] elements) {
        this.elements = elements;
    }

    public E[] getElements() {
        return elements;
    }

    public void test() {
        ArrayGen array = new ArrayGen(new Integer[]{1, 2, 3});
        System.out.println(Arrays.toString(array.getElements()));
        array = new ArrayGen(new String[]{"a", "b", "c"});
        System.out.println(Arrays.toString(array.getElements()));
    }

    public E get(int index) {
        return elements[index];
    }

    public void test1() {
        ArrayGen array = new ArrayGen(new Integer[]{1, 2, 3});
        System.out.println(array.get(2));
    }
}