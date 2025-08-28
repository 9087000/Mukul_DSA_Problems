package GFG;

import java.util.Scanner;

public class MaximizeNumberof1s {
    public static class solution {
        public static void mian(String args[]) {
            Scanner sc = new Scanner(System.in);
            int s = sc.nextInt();

            while (s-- > 0) {
                int n = sc.nextInt();
                int[] arr = new int[n];
                int k = sc.nextInt();
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                int ones = maxOnes(arr, k);
                System.out.println(ones);
            }
        }

        public static int maxOnes(int[] arr, int k) {
            int start = 0, maxDepth = 0, zerosCount = 0;
            for (int end = 0; end < arr.length; end++) {
                if (arr[end] == 0) {
                    zerosCount++;
                }
                while (zerosCount > maxDepth) {
                    if (arr[start] == 0) {
                        zerosCount--;
                    }
                    start++;
                }
                maxDepth = Math.max(maxDepth, end - start + 1);
            }
            return maxDepth;
        }
    }
}
