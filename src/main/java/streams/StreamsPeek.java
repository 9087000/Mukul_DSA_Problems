package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//It help to debug or to see the intermediate result of processiing stream peek(Consumer<T> action)
public class StreamsPeek {
    public static void main(String args[]) {
        List<Integer> arrays = Arrays.asList(2,3,4,1,6,5);
        Stream<Integer> s = arrays.stream()
                .filter((Integer val) -> val > 2)
                .peek((Integer val) -> System.out.println(val))
                .map((Integer val) -> -1 * val);
        List<Integer> t = s.toList();
        System.out.println(t);
    }
}
