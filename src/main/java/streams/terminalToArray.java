package streams;

import java.util.Arrays;
import java.util.List;

//It is used to collect elements of stream in to an array toArray()
public class terminalToArray {
    public static void main(String args[]) {
        List<Integer> k = Arrays.asList(3,4,5,6,7,8,9,10);
        Object[] j = k.stream()
                .filter((Integer val) -> val >=3)
                .toArray();
        System.out.println(Arrays.toString(j));
        Integer[] o = k.stream()
                .filter((Integer val) -> val >=3)
                .toArray((int size) -> new Integer[size]);
        System.out.println(Arrays.toString(o));
    }
}
