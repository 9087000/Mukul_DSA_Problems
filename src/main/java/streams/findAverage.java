package streams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class findAverage {
    public static void main(String args[]) {
        List<Integer> nums = Arrays.asList(5,12,15,20,8,25,50,75);
        OptionalDouble s = findAverages(nums);
        System.out.println(s);
    }

    private static OptionalDouble findAverages(List<Integer> nums) {
        return nums.stream()
                .filter(p -> p>10)
                .mapToDouble(Integer::doubleValue)
                .average();
    }
}
