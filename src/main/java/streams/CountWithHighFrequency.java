package streams;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountWithHighFrequency {
    public static void main(String[] args) {
        String s = "abacccbd";
        Character c = CountWithHighFrequency(s);
        System.out.println(c);
    }

    private static Character CountWithHighFrequency(String s) {
        return s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c-> c , HashMap::new , Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(f-> f.getKey())
                .orElse(null);
    }
}
