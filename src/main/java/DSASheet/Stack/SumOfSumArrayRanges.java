package DSASheet.Stack;

import java.util.Stack;

public class SumOfSumArrayRanges {
    public static void main(String[] args) {
        int[] nums = {4,-2,-3,4,1};
        long sum = subArrayRanges(nums);
        System.out.println(sum);
    }
    private static long subArrayRanges(int[] nums) {
//        int n = nums.length;
//        long result = 0;
//        for(int i=0; i<n; i++) {
//            int minval = nums[i];
//            int maxVal = nums[i];
//            for(int j=i; j<n; j++) {
//                minval = Math.min(minval, nums[j]);
//                maxVal = Math.max(maxVal , nums[j]);
//                result += (maxVal - minval);
//            }
//        }
//        return result;
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];
        int[] prevGreater = new int[n];
        int[] nextGreater = new int[n];

        for(int i=0; i<n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }
            prevSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for(int i=n-1; i>=0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            nextSmaller[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for(int i=0; i<n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }
            prevGreater[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();
        for(int i=n-1; i>=0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            nextGreater[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long result = 0;
        for(int i=0; i<n; i++) {
            long leftMin = i - prevSmaller[i];
            long rightMin = nextSmaller[i] - i;
            long contibutionMin = (long) nums[i] * leftMin * rightMin;

            long leftMax = i - prevGreater[i];
            long rightMax = nextGreater[i] - i;
            long contibutionMax = (long) nums[i] * leftMax * rightMax;

            result += (contibutionMax - contibutionMin);
        }
        return result;
    }
}
