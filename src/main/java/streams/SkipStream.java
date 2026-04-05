package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

//Skip first n elements of stream skip(long n)
public class SkipStream {
    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(2,1,3,4,5,6,7);
        Stream<Integer> l = list.stream().skip(3);
        List<Integer> lt = l.toList();
        System.out.println(lt);
    }
}
