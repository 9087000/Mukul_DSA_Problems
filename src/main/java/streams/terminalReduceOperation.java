package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//does reduction on element of stream perform associative aggregation function reduce(BinaryOperator<T> accumulator)
public class terminalReduceOperation {
    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(2,1,4,7,10,12);
        Optional<Integer> reduce = list.stream()
                .reduce((Integer val1, Integer val2) -> val1 + val2);
        System.out.println(reduce.get());
    }
}
