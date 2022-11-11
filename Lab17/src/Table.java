import java.util.HashMap;
import java.util.Objects;

public class Table {
    private int count = 0;
    private int[] allIndex;
    private int index;
    private OrderManager orderManager;
    private HashMap<Integer, String> hashMap;

    public void connect(int index, String address) throws Exception {
        boolean f = false;
        for (int i = 0; i < allIndex.length; i++) {
            if (allIndex[i] == index) {
                f = true;
                break;
            }
        }
        if (!f) {
            for (String temp : hashMap.values()) {
                if (Objects.equals(address, temp)) {
                    f = true;
                    break;
                }
            }
            for (int temp : hashMap.keySet()) {
                if (index == temp) {
                    f = true;
                    break;
                }
            }
            if (f) throw new Exception("OrderAlreadyAddedException");
            else hashMap.put(index, address);
            int[] temp = new int[count];
            System.arraycopy(allIndex, 0, temp, 0, allIndex.length);
            allIndex = new int[count + 1];
            System.arraycopy(temp, 0, allIndex, 0, temp.length);
            allIndex[count + 1] = index;
            count++;
        }
    }
}
