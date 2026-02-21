package DSASheet.RecursionAndBackTracking;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CountFrequencyOfCharcter {
    public static void main(String[] args) {
        String s = "mukul";
        Map<Character, Integer> c = countfrequency(s);
        System.out.println(c);
    }
    private static  Map<Character, Integer> countfrequency(String s) {
        Map<Character, Integer> m = new LinkedHashMap<>();

        for(char c : s.toCharArray()) {
            m.put(c,m.getOrDefault(c, 0) + 1);
        }
        return m;
    }
}
