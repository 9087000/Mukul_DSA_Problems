package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaxNumbers {
    public static void main(String args[]) {
        List<Integer> max = Arrays.asList(10,25,5,40,15);
        List<Integer> num = maxNumbers(max);
        System.out.println(num);
    }
    private static List<Integer> maxNumbers(List<Integer> max) {
        return max.stream()
                .max((Integer val1, Integer val2) -> val1 - val2)
                .stream().collect(Collectors.toList());
    }
}
