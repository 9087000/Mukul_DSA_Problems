package streams;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class FirstRepatingCharacters {
    public static void main(String[] args) {
        String s = "abacbd";
        Character c = firstRepeatingCharcter(s);
        System.out.println(c);
    }

    private static Character firstRepeatingCharcter(String s) {
        return s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(f -> f.getValue()>1)
                .map(d-> d.getKey())
                .findFirst()
                .orElse(null);
    }
}
