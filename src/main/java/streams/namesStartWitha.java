package streams;

import java.util.Arrays;
import java.util.List;

public class namesStartWitha {
    public static void main(String args[]) {
        List<String> names = Arrays.asList("arun", "ram", "ajay", "john", "anil");
        long s = namesStartWitha(names);
        System.out.println(s);
    }

    private static long namesStartWitha(List<String> name) {
        return name.stream()
                .filter((String names) -> names.startsWith("a"))
                .count();
    }
}
