package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;

public class mapToDoubleStreams {
    public static  void main(String args[]) {
        List<String> numbers = Arrays.asList("10", "20", "30", "40", "50");
        DoubleStream doubleStream = numbers.stream().mapToDouble((String val) -> Double.parseDouble(val));
        double[] arrays = doubleStream.toArray();
        System.out.println(Arrays.toString(arrays));
        //
        double[] array = {10, 20, 30, 40, 50};
        DoubleStream doubleStream1 = Arrays.stream(array);
        double[] arr =  doubleStream1.filter((double val) -> val > 30).toArray();
        System.out.println(Arrays.toString(arr));
        //
        List<Integer> number = Arrays.asList(10, 20, 30);
        double average = number.stream()
                .mapToDouble(n-> n)
                .average()
                .orElse(0.0);
        System.out.println(average);
    }
}
