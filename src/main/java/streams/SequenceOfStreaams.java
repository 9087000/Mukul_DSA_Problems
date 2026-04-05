package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SequenceOfStreaams {
    public static void main(String args[]) {
        List<Integer> streamList = Arrays.asList(2,1,4,7,10);
        Stream<Integer> streamOfInteger = streamList.stream()
                .filter((Integer e) -> e>=3)
                .peek((Integer val) -> System.out.println("After filtering value is :" + val))
                .map((Integer val) -> -1 * val)
                .peek((Integer val) -> System.out.println("After Negating output" + val))
                .sorted()
                .peek((Integer val) -> System.out.println("After sorting :" + val));
        List<Integer> filterValues = streamOfInteger.toList();
    }
}
