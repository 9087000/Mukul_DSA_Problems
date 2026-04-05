package streams;

import java.util.*;

public class findAverage {
    public static void main(String args[]) {
        List<Integer> nums = Arrays.asList(1,2,3,2,4,5,3,6);
        Integer s = findAverages(nums);
        System.out.println(s);
    }

    private static Integer findAverages(List<Integer> nums) {
        Set<Integer> seen = new HashSet<>();
        return nums.stream()
                .min(Integer::compareTo)
                .orElse(null);
    }
}
