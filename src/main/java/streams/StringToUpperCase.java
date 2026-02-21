package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToUpperCase {
    public static void main(String args[]) {
        List<String> names = Arrays.asList("java", "spring", "boot");
        List<String> n = StringtoUpperCase(names);
        System.out.println(n);
    }

    private static List<String> StringtoUpperCase(List<String> name) {
        return name.stream()
                .map((String names) -> names.toUpperCase())
                .collect(Collectors.toList());
    }
}
