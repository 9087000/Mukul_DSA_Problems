package streams;

import java.util.Arrays;
import java.util.List;

//checks if all value match in the stream matches the given predicate and return boolean allMatch(Predicate<T> predicate)
public class allMatchTerminal {
    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        Boolean all = list.stream()
                .allMatch((Integer val) -> val >3);
        System.out.println(all);
    }
}
