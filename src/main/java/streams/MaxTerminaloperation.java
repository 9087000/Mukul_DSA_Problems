package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//Finds the max value from the streams based on the comparator provided max(Comparator<T> comparator)
public class MaxTerminaloperation {
    public static void main(String args[]) {
        List<Integer> lists = Arrays.asList(2,3,1,4,7,10);
        Optional<Integer> in = lists.stream()
                .max((Integer val1, Integer val2) -> val1 - val2);
        Integer max = in.orElse(null);
        System.out.println(max);
        Optional<Integer> out = lists.stream()
                .max((Integer val1, Integer val2) -> val2 - val1);
        Integer max1 = in.orElse(null);
        System.out.println(max1);
    }
}
