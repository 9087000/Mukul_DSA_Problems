package streams;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//Find Any random element of the stream
public class FindAny {
    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        Optional<Integer> opt = list.stream()
                .findAny();
        System.out.println(opt.get());
    }
}
