package streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsIterate {
    public static void main(String args[]) {
        Stream<Integer> streamsFromIterate = Stream.iterate(1000, (Integer n) -> n + 5000).limit(5);
        List<Integer> iterate =  streamsFromIterate.collect(Collectors.toList());
        System.out.println(iterate);
    }
}
