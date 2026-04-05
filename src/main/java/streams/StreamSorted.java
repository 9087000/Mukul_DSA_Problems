package streams;

import java.util.Arrays;
import java.util.List;

//It is used to sort the elements
public class StreamSorted {
    public static void main(String args[]) {
        Integer[] arr = {1,4,5,6,7,7,0,4,9,2,4};
        //Ascending order
//        List<Integer> sort = Arrays.stream(arr)
//                .sorted().toList();
        //Descending order
        List<Integer> sort = Arrays.stream(arr)
                        .sorted((Integer val1, Integer val2) ->val2 - val1)
                        .toList();
        System.out.println(sort);
    }
}
