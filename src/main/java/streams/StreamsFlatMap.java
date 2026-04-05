package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.BaseStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//it is used to iterate over each element of complex collection and helps to flatten it. flatMap(Function<T, Stream<R> Mapper)
public class StreamsFlatMap {
    public static void main(String args[]) {
        List<List<String>> sentenceList = Arrays.asList(Arrays.asList("I", "LOVE", "JAVA"), Arrays.asList("CONCEPTS", "ARE", "CLEAR"), Arrays.asList("IT", "VERY", "EASY"));
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(1,2,3), Arrays.asList(4,5,6), Arrays.asList(7,8,9));
        // normal faltmap iteration over each element of complex collection and flattening it before streaming it
//        Stream<String> map = sentenceList.stream().flatMap((List<String> sentence) -> sentence.stream());
//        List<String> s = map.collect(Collectors.toList());
        Stream<String> maps = sentenceList.stream().flatMap((List<String> sentences) -> sentences.stream().map((String name) -> name.toLowerCase()));
        List<String> s = maps.collect(Collectors.toList());
        Stream<Integer> d = lists.stream().flatMap((List<Integer> even) -> even.stream().filter((Integer n) -> n%2==0));
        List<Integer> s1 = d.distinct().sorted().toList();
        System.out.println(s1);
    }
}
