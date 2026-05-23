package DSASheet.Stack;

import java.util.Stack;

public class LargestReactangleHistogram {
    public static void main(String args[]) {
        int[] heights = {5,4,3,2,1};
        int reactangle = largestRectangle(heights);
        System.out.println(reactangle);
    }
    private static int largestRectangle(int[] height) {
        //brute
//        int n = height.length;
//        int maxArea = 0;
//
//        for(int i=0; i<n; i++) {
//            int heights = height[i];
//            int left = i;
//            int right = i;
//
//            if(left-1 >= 0 && height[left-1]>= heights) {
//                left--;
//            }
//
//            if(right+1 < n && height[right+1] >= heights) {
//                right++;
//            }
//
//            int width = right - left + 1;
//            int area = heights * width;
//
//            maxArea = Math.max(maxArea, area);
//        }
//        return maxArea;
        //optimized
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for(int i=0; i<n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                int top = stack.pop();
                int heights = height[top];

                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = i;

                int width = right - left - 1;
                int area = heights * width;
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
            while(!stack.isEmpty()) {
                int top = stack.pop();
                int heights = height[top];

                int left = stack.isEmpty() ? -1 : stack.peek();
                int right = n;

                int width = right - left - 1;
                int area = heights * width;
                maxArea = Math.max(maxArea, area);
            }
        return maxArea;
    }
}
