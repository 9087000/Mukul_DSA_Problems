package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//Once terminal operation is used in the stream, it is closed/consumed and cannot be used for another terminal operation
public class TwoTerminalOperation {
    public static void main(String args[]) {
        List<Integer> i = Arrays.asList(1,2,3,4,5);
       Stream<Integer> stream =  i.stream()
                .filter((Integer val) -> val>=3);
       stream.forEach((Integer val) -> System.out.println(val));
        List<Integer> filrerNumbers = stream
                .toList();
        System.out.println(filrerNumbers);
    }
}
