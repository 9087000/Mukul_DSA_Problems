package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsFromArray {
    public static void main(String args[]) {
        Integer[] salaryArray = {3000, 4100, 9000, 1000, 3500};
        Stream<Integer> streamFromArray = Arrays.stream(salaryArray);
        List<Integer> arrays = streamFromArray.collect(Collectors.toList());
        System.out.println(arrays);
    }
}
