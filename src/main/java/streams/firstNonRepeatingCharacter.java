package streams;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class firstNonRepeatingCharacter {
    public static void main(String args[]) {
        String s = "abacbd";
        Character c = firstNonRepeatingCharacter(s);
        System.out.print(c);
    }

    private static Character firstNonRepeatingCharacter(String s) {
        return s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy( c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e-> e.getValue()==1)
                .map(e->e.getKey())
                .findFirst()
                .orElse(null);
    }
}
