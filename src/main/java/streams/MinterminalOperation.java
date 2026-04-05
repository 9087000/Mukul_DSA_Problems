package streams;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//Finds the minimum value from the stream based on the comparator provided min(Comparator <T> comparator>
public class MinterminalOperation {
    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        Optional<Integer> in = list.stream()
                .min((Integer val1, Integer val2) -> val1 - val2);
        Integer min = in.orElse(null);
        System.out.println(min);
        Optional<Integer> out = list.stream()
                .min((Integer val1, Integer val2) -> val2 - val1);
        Integer m = out.orElse(null);
        System.out.println(m);
    }
}
