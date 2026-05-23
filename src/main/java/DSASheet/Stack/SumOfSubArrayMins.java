package DSASheet.Stack;

import java.util.Stack;

public class SumOfSubArrayMins {
    public static void main(String[] args) {
        int[] arr = {2,2};
        int subarraymin = sumOfSubArray(arr);
        System.out.println(subarraymin);
    }

    private static int sumOfSubArray(int[] arr) {
        //brute
//        int n= arr.length;
//        int result = 0;
//        for(int i=0; i<n; i++) {
//            int min = Integer.MAX_VALUE;
//            for(int j=i; j<n; j++) {
//                min= Math.min(min, arr[j]);
//                result+=min;
//            }
//        }
//        return result;
        //optimized
        int n = arr.length;
        int mod = 1_000_000_007;
        Stack<Integer> stack = new Stack<>();
        int[] prevIndex = new int[n];
        int[] nextIndex = new int[n];

        for(int i=0; i<n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prevIndex[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for(int i=n-1; i>=0; i--) {
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nextIndex[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long result = 0;
        for(int i=0; i<n; i++) {
            long left = i - prevIndex[i];
            long right = nextIndex[i] - i;
            long combination = (long) arr[i] * left * right;

            result = (result + combination) % mod;
        }

        return (int) result;
    }
}
