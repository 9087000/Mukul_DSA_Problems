package streams;

import java.util.Arrays;
import java.util.List;

//Helps us to perform operation on streams concurrently , taking advantage of multi-core CPU
//ParallelStreams() is used instead of the  normal streams
//Task Spliting : It uses the splitIterator() to split data into mutiple chunks
//Task submission and parallelProcessing: Use fork-join pool common pool technique
public class PallelStreams {
    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(11,22,33,44,55,66,77,88,99,110);

        long sequentialProcessingTime = System.currentTimeMillis();

        // sequentialProcessing
        list.stream()
                .map((Integer val) -> val * val)
                .forEach((Integer val) -> System.out.println(val));

        System.out.println("Sequential Processing Time:" + (System.currentTimeMillis() - sequentialProcessingTime) + "millSecond");

        long parallelProcessingTime = System.currentTimeMillis();

        //ParallelProcessing
        list.parallelStream()
                .map((Integer val)-> val * val)
                .forEach((Integer val) -> System.out.println(val));
        System.out.println("Parallel Processing Time:" + (System.currentTimeMillis() - parallelProcessingTime) + "milliseconds");
    }
}
