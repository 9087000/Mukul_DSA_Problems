package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
//It is used to remove the duplicate elements from streams
public class StreamDistnct {
    public static void main(String args[]) {
        Integer[] arr = {1,3,4,5,4,7,7,8,0,1};
        List<Integer> s = Arrays.stream(arr)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(s);
    }
}
