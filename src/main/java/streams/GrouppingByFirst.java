package streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GrouppingByFirst {
    public static void main(String args[]) {
        List<String> names = Arrays.asList("Ram", "Ravi", "Arun", "Anu", "Ajay");
        Map<Character, List<String>> s = GrouppingByFirstStream(names);
        System.out.println(s);
    }

    private static Map<Character, List<String>> GrouppingByFirstStream(List<String> names) {
        return names.stream()
                .collect(Collectors.groupingBy(name-> name.charAt(0), Collectors.toList()));
    }
}
