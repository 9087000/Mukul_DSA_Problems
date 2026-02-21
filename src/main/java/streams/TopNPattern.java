package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TopNPattern {
    public static void main(String args[]) {
        List<Integer> num = Arrays.asList(5, 1, 9, 3, 7 , 6);
        List<Integer> s = Topnpattern(num);
        System.out.println(s);
    }

    private static List<Integer> Topnpattern(List<Integer> nums) {
        return nums.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .collect(Collectors.toList());

    }
}
