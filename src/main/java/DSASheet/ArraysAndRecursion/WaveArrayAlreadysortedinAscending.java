package DSASheet.ArraysAndRecursion;

import java.util.Scanner;
//step - 0
//n -> length(arr)
//if n<1 Then return (array already satisfies value
//step 1:
//for index i from 0 to n-2 stepping by 2:
//swap arr[i] and arr[i+1]
public class WaveArrayAlreadysortedinAscending {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().trim();

        // strip brackets; split on commas or whitespace
        line = line.replaceAll("[\\[\\]]", "");
        if (line.isEmpty()) {
            System.out.println(); // empty array
            return;
        }
        String[] parts = line.split("[,\\s]+");
        int n = parts.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(parts[i]);

        sortInWave(arr);

        // print in same style
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(arr[i]);
        }
        System.out.println("]");
    }
    public static void sortInWave(int[] arr) {
        for(int i=0; i+1 < arr.length; i+=2) {
            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }

}
