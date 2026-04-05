package streams;

import java.util.Arrays;
import java.util.List;

//Terminal Operation are the ones that produces the result. It triggers Processing of the stream
//forEach perform action on every element of stream . Does not return any value forEach<Consumer<T> action)
public class TerminalOperationforEachStream {
    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        list.stream()
                .filter((Integer val) -> val >2)
                .forEach((Integer val) -> System.out.println(val));
    }
}
