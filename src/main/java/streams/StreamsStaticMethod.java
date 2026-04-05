package streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsStaticMethod {
    public static void main(String args[]) {
        Stream<Integer> streamStaticMethod = Stream.of(3000, 4100, 9000);
        List<Integer> statics = streamStaticMethod.collect(Collectors.toList());
        System.out.print(statics);
    }
}
