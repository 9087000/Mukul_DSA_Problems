package streams;

import java.util.Arrays;
import java.util.List;

//can be used to collect elements of the streams into a list. collect(Collector<T,A,R> collector)
public class TerminalCollect {
    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> st = list.stream()
                .filter((Integer val) -> val >=3)
                .toList();
        System.out.println(st);
    }
}
