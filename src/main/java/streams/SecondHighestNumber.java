package streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SecondHighestNumber {
    public static void main(String[] args) {
        int[] arr = {10,12,20,8,15,20};
        int highest = findSecondHighest(arr);
        System.out.println(highest);
    }

    private static int findSecondHighest(int[] arr) {
      return Arrays.stream(arr)
              .distinct()
              .boxed()
              .sorted((a,b) -> b - a)
              .skip(1)
              .findFirst()
              .orElse(null);

    }
}
