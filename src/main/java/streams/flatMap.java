package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class flatMap {
    public static void main(String args[]) {
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1,2),
                Arrays.asList(3,4),
                Arrays.asList(5,6)
        );
        List<Integer> s = flatMaps(list);
        System.out.println(s);
    }

    private static List<Integer> flatMaps(List<List<Integer>> list) {
        return list.stream()
                .flatMap(lists -> lists.stream())
                .collect(Collectors.toList());
    }
}
