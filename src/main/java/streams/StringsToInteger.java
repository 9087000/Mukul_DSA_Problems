package streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class StringsToInteger {
    public static void main(String args[]) {
        List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6");
        Integer s = StringsToInt(list);
        System.out.println(s);
    }

    private static Integer StringsToInt(List<String> list) {
        return list.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
