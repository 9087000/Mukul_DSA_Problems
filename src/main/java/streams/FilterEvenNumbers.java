package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterEvenNumbers {
    public static void main(String args[]) {
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8);
        List<Integer> n = filterEvenNumbers(nums);
        System.out.println(n);
    }

    private static List<Integer> filterEvenNumbers(List<Integer> nums) {
        return nums.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }
}
