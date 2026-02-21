package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SquareOfNumbers {
    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(2,4,6,8,10,12,14,15,18);
        Integer s = sqaureOfNumber(num);
        System.out.println(s);
    }

    private static  Integer sqaureOfNumber(List<Integer> num) {
        return num.stream()
                .filter(n -> n%2 == 0)
                .mapToInt(h->h*h)
                .sum();
    }
}
