package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//checks if any value in the  stream matches the given predicate and return boolean anyMatch(Predicate<T> predicate)
public class anyMatchTerminal {
    public static void main(String args[]) {
        List<Integer> s = Arrays.asList(1,2,3,4,5,6,7);
        Boolean i = s.stream()
                .anyMatch((Integer val) -> val>=3);
        System.out.println(i);
    }
}
