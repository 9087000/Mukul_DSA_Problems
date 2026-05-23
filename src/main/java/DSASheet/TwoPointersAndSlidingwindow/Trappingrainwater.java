package DSASheet.TwoPointersAndSlidingwindow;

import java.util.Stack;

import static java.lang.Math.min;

public class Trappingrainwater {
    public static void main(String[] args) {
        int[] height = {4,2,0,3, 2,5};
        int trap = trappingwater(height);
        System.out.println(trap);
    }
    private static int trappingwater(int[] height) {
//        int sum =0;
//        for(int i=0; i<height.length; i++) {
//           int leftMax = 0;
//           int rightMax = 0;
//           for(int j=0;j<=i;j++) {
//               leftMax = Math.max(leftMax, height[j]);
//           }
//
//           for (int j=i; j<height.length; j++) {
//               rightMax = Math.max(rightMax, height[j]);
//           }
//
//
//           sum+= min(leftMax , rightMax) - height[i];
//        }
//        return sum;
//        int leftMax = 0;
//        int rightMax = 0;
//        int left = 0;
//        int right = height.length - 1;
//        int sum = 0;
//        while (left<right){
//            if(height[left] <= height[right]) {
//                if (height[left] >= leftMax) {
//                    leftMax = height[left];
//                } else {
//                    sum += leftMax - height[left];
//                }
//                left++;
//            } else {
//                if (height[right] >= rightMax) {
//                    rightMax = height[right];
//                } else {
//                    sum+= rightMax - height[right];
//                }
//                right--;
//            }
//        }
//        return sum;
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int water = 0;

        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottom = stack.pop();

                if(stack.isEmpty()) break;
                int left = stack.peek();
                int right = i;

                int width = right-left-1;
                int boundary = Math.min(height[left], height[right]) - height[bottom];

                water+=width*boundary;
            }
            stack.push(i);
        }
        return water;
    }
}
