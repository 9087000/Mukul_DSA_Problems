package streams;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class Countfrequency {
    public static void main(String args[]) {
        String nam = "banana";
        Map<Character, Long> c =  countFrequency(nam);
        System.out.println(c);
    }

    private static Map<Character, Long> countFrequency(String nam) {
        return nam.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c-> c , LinkedHashMap::new , Collectors.counting()));

    }
}
