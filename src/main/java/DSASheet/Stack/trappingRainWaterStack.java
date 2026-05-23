package DSASheet.Stack;

import java.util.Stack;

import static java.lang.Math.min;

public class trappingRainWaterStack {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int water = trappingRainWaterstack(height);
        System.out.println(water);
    }
    private static int trappingRainWaterstack(int[] height) {
        //brute
//        int n = height.length;
//        int sum = 0;
//        for(int i=0; i<n; i++) {
//            int leftMax = 0;
//            int rightMax = 0;
//            for(int j=0; j<=i;j++) {
//                leftMax = Math.max(leftMax, height[j]);
//            }
//
//            for(int j=i; j<n; j++) {
//                rightMax = Math.max(rightMax, height[j]);
//            }
//
//            sum+=min(leftMax, rightMax) - height[i];
//        }
//        return sum;
        //stack Optimized
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int water = 0;

        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop();
                if(stack.isEmpty()) break;
                int left = stack.peek();
                int right = i;

                int width = right - left - 1;
                int boundary = Math.min(height[left], height[right]) - height[bottom];

                water+=width * boundary;
            }
            stack.push(i);
        }
        return water;
    }
}
