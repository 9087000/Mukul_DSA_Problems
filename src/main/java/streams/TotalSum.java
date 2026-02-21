package streams;

import java.util.Arrays;
import java.util.List;

public class TotalSum {
    public static void main(String args[]) {
        List<Integer> nums = Arrays.asList(5,10,15,20);
        Long s = totalSum(nums);
        System.out.println(s);
    }

    private static long totalSum(List<Integer> n) {
        return n.stream()
                .reduce((Integer val1, Integer val2) -> val1 + val2)
                .get();
    }
}
