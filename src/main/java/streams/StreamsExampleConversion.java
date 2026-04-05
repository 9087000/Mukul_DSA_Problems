package streams;

import java.util.ArrayList;
import java.util.List;

public class StreamsExampleConversion {
    public static void main(String args[]) {
        List<Integer> salaryList = new ArrayList<>();
        salaryList.add(3000);
        salaryList.add(4100);
        salaryList.add(9000);
        salaryList.add(1000);
        salaryList.add(3500);
        long count = salaryList.stream().filter(e-> e>3000).count();
        System.out.println("Total Employee Count greater than 3000:" + count);
    }
}
