package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//Find the first element of the stream
public class FindFirstElement {
    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        Optional<Integer> find = list.stream().findFirst();
        System.out.println(find.get());
    }
}
