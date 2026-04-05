package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//Truncate the streams to have no longer than given max size lint(long maxSize)
public class LimitStream {
    public static void main(String args[]) {
        List<Integer> s = Arrays.asList(2,1,3,4,5,6);
        Stream<Integer> t = s.stream()
                .limit(3);
        List<Integer> i = t.toList();
        System.out.println(i);
    }
}
