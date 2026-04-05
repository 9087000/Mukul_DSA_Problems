package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class exampleIntermediate {
    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);
        Stream<Integer> listofStream = list.stream().filter((Integer val) -> val >3).peek((Integer val) -> System.out.println(val));
        List<Integer> listOfValue = list.stream().filter((Integer val) -> val > 3).peek((Integer val) -> System.out.println(val)).toList();
        Long longValue = list.stream().filter((Integer val) -> val > 3).peek((Integer val) -> System.out.println(val)).count();
//        System.out.println(listOfValue);
//        System.out.println(longValue);
    }
}
