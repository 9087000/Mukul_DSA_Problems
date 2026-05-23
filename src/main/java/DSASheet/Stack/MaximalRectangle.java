package DSASheet.Stack;

import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        int area = maxRectnagle(matrix);
        System.out.println(area);
    }
    private static int maxRectnagle(char[][] matrix) {
       //brute
//       if(matrix.length == 0) return  0;
//       int rows = matrix.length;
//       int cols = matrix[0].length;
//
//       int maxArea = 0;
//       for(int i=0; i<rows; i++) {
//           for(int j=0; j<cols; j++) {
//               if(matrix[i][j] == '0') continue;
//
//               int minWidth = Integer.MAX_VALUE;
//
//               for(int k=i; k<rows; k++) {
//                   if(matrix[k][j] == '0') break;
//
//                   int width = 0;
//                   int c = j;
//
//                   while(c<cols && matrix[k][c] == '1') {
//                       width++;
//                       c++;
//                   }
//
//                   minWidth = Math.min(minWidth, width);
//
//                   int height = k - i + 1;
//                   int area = minWidth * height;
//
//                   maxArea = Math.max(maxArea, area);
//               }
//           }
//       }
//       return maxArea;
        //optimized
        if(matrix.length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] height = new int[cols];
        int maxArea = 0;

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestReactangle(height));
        }
        return maxArea;
    }

    private static int largestReactangle(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int n = height.length;
        int maxArea = 0;

        for(int i=0; i<=n; i++) {
            int currentHeight = (i == n) ? 0 : height[i];
            while(!stack.isEmpty() && currentHeight < height[stack.peek()]) {
                int heights = height[stack.pop()];

                int right = i;
                int left = stack.isEmpty() ? -1 : stack.peek();

                int width = right - left - 1;
                maxArea = Math.max(maxArea , heights * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
