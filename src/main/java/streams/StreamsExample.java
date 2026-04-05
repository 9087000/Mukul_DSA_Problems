package streams;

import java.util.ArrayList;
import java.util.List;

public class StreamsExample {
    public static void main(String args[]) {
        List<Integer> salaryList = new ArrayList<>();
        salaryList.add(3000);
        salaryList.add(4100);
        salaryList.add(9000);
        salaryList.add(1000);
        salaryList.add(3500);
        int count = 0;
        for(int salary: salaryList) {
            if(salary > 3000) {
                count++;
            }
        }
        System.out.println("Total Employee count greater than 3000 :" + count) ;
    }
}
