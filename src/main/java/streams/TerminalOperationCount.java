package streams;

import java.util.Arrays;
import java.util.List;

//returns count of elements present in the stream
public class TerminalOperationCount {
    public static void main(String args[]) {
        List<Integer> m = Arrays.asList(1,2,3,4,5,6,7);
        long s = m.stream()
                .filter((Integer val) -> val >=3)
                .count();
        System.out.println(s);
    }
}
