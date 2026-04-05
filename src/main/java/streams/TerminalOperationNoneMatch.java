package streams;

import java.util.Arrays;
import java.util.List;

//checks if none value in the stream matches the given predicate and return boolean noneMatch(Predicate<T> predicate)
public class TerminalOperationNoneMatch {
    public static void main(String args[]) {
        List<Integer> o = Arrays.asList(1,2,3,4,5,6,7);
        boolean i = o.stream()
                .noneMatch((Integer val) -> val>8);
        System.out.println(i);
    }
}
