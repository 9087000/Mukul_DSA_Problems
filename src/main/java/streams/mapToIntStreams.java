package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
//helps to work with primitive "int" data types mapToInt(ToIntFunction<T> mapper)
public class mapToIntStreams {
    public static void main(String args[]) {
        List<String> ints =Arrays.asList("2","3","1","4","6","7");
        IntStream numberStreams = ints.stream().mapToInt((String val) -> Integer.parseInt(val));
        int[] numberArray = numberStreams.toArray();
        System.out.println(Arrays.toString(numberArray));
        int[] numbersArray = {2,1,3,4,7,9};
        int[] numbersStreams = Arrays.stream(numbersArray).filter((int val) -> val>2).toArray();
        System.out.println(Arrays.toString(numbersStreams));
    }
}
