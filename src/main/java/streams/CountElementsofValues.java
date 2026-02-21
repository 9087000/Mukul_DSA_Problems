package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountElementsofValues {
    public static void main(String args[]) {
        List<String> name = Arrays.asList("ram", "john", "aravind", "arun");
        List<Integer> s = CountElements(name);
        System.out.println(s);
    }

    private static List<Integer> CountElements(List<String> name) {
        return name.stream()
                .map((String t) -> t.toUpperCase())
                .map(names -> names.length())
                .collect(Collectors.toList());
    }
}
