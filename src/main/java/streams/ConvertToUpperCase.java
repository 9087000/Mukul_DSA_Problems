package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertToUpperCase {
    public static void main(String args[]) {
        List<String> name = Arrays.asList("ram", "john", "arun", "david");
        List<String> s = upperCase(name);
        System.out.println(s);
    }

    private static List<String> upperCase(List<String> name) {
        return name.stream()
                .map((String names) -> names.toUpperCase())
                .collect(Collectors.toList());
    }
}
