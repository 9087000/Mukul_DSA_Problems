package DSASheet.Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementII {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        int[] nextGreat = nextGreaterElementII(nums);
        System.out.println(Arrays.toString(nextGreat));
    }

    private static int[] nextGreaterElementII(int[] nums) {
        //brute
//        int n = nums.length;
//        int[] result = new int[n];
//        Arrays.fill(result, -1);
//
//        for(int i=0; i<n; i++) {
//            for(int step=1; step<n; step++) {
//                int j = (i + step) % n;
//                if(nums[j] > nums[i]) {
//                    result[i] = nums[j];
//                    break;
//                }
//            }
//        }
//        return result;
         //optimized
         int n = nums.length;
         int[] result = new int[n];
         Arrays.fill(result, -1);

         Stack<Integer> stack = new Stack<>();

         for(int i=0; i<2*n; i++) {
             int current = nums[i % n];

             while(!stack.isEmpty() && current > nums[stack.peek()]) {
                 int prevIndex = stack.pop();
                 result[prevIndex] = current;
             }

             if(i < n) {
                 stack.push(i);
             }
         }
         return result;
    }
}
