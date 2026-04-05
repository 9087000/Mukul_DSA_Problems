package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

//Helps to work with primitive "Long" data types mapToLong<ToLongFunction<T> mapper>
public class mapToLongStreams {
    public static void main(String args[]) {
        List<String> lists = Arrays.asList("10", "20", "30", "40", "50");
        LongStream numberStreams = lists.stream().mapToLong((String val) -> Long.parseLong(val));
        long[] arrayNumber = numberStreams.toArray();
        System.out.println(Arrays.toString(arrayNumber));
        //
        long[] array = {10,20,30,40,50};
        LongStream numberedStream = Arrays.stream(array);
        long[] filteredArray = numberedStream.filter((long e) -> e>20).toArray();
        System.out.println(Arrays.toString(filteredArray));
        //
        List<String> value = Arrays.asList("10", "20", "30");
        long stream = value.stream()
                .mapToLong(Long::parseLong)
                .sum();
        System.out.println(stream);
    }
}
