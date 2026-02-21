package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class filternumber {
    public static void main(String args[]) {
        List<Integer> nums = Arrays.asList(10, 15, 20, 25, 30, 35);
        List<Integer> s = filterAndMutiply(nums);
        System.out.println(s);
    }

    private static List<Integer> filterAndMutiply(List<Integer> nums) {
        return nums.stream()
                .filter(n -> n % 5 == 0)
                .map(p -> p * 2)
                .collect(Collectors.toList());
    }
}
