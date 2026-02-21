package streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class LeastFrequencyCharacter {
    public static void main(String args[]){
        String s = "abacccbd";
        Character c = leastFrequencyCharacter(s);
        System.out.println(c);

    }

    private static Character leastFrequencyCharacter(String s) {
        return s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c->c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .map(f-> f.getKey())
                .orElse(null);
    }
}
