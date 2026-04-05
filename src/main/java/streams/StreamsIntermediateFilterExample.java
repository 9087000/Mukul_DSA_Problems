package streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//intermediate operation we can chain multiple intermediate operation together  to perform complex procession before applying terminal operation to produce the result
// filter is used for filtering the element filter(Predicate<T> predicate)
public class StreamsIntermediateFilterExample {
    public static void main(String args[]) {
        Stream<String> names = Stream.of("HELLO", "EVERYBODY", "HOW", "ARE", "YOU", "DOING");
        Stream<String> filterName = names.filter((String name) ->  name.length()<=3);
        List<String> list = filterName.collect(Collectors.toList());
        System.out.print(list);
    }
}
