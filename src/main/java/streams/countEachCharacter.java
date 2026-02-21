package streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class countEachCharacter {
    public static void main(String args[]) {
        List<String> names = Arrays.asList("John", "Jack", "Jill", "Arun", "Anu");
        Map<Character, List<String>> n = countEach(names);
        System.out.println(n);
    }

    private static Map<Character, List<String>> countEach(List<String> names) {
        return names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0), Collectors.toList()));
    }
}
