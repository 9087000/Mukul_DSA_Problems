package streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBuilder {
    public static void main(String args[]) {
        Stream.Builder<Integer> streamBuilder = Stream.builder();
        streamBuilder.add(3000).add(4100).add(9000);
        Stream<Integer> streamFromStreamBuilder = streamBuilder.build();
        List<Integer> stream = streamFromStreamBuilder.collect(Collectors.toList());
        System.out.println(stream);
    }
}
