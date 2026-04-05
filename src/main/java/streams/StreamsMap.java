package streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//map is used to transform each element into another form Map(Function<T,R mapper>)
public class StreamsMap {
    public static void main(String args[]) {
        Stream<String> namesStream = Stream.of("HELLO", "EVERYBODY", "HOW", "ARE", "YOU", "DOING");
        List<String> filteredLoweCase = namesStream.map((String name) -> name.toLowerCase()).collect(Collectors.toList());
        System.out.println(filteredLoweCase);
    }
}
