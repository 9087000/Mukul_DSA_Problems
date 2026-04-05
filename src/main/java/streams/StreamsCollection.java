package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsCollection {
    public static void main(String args[]) {
        List<Integer> salaryList = Arrays.asList(3000,4100, 9000, 1000, 3500);
        Stream<Integer> streamsFromcollection = salaryList.stream();
        List<Integer> streams = streamsFromcollection.collect(Collectors.toList());
        System.out.println(streams);
    }
}
