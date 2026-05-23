package DSASheet.BinarySearch;

import java.util.Arrays;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[][] matrix = {{1,5,9}, {10,11,13},{12,13,15}};
        int k = 8;
        int smallest = kthsmallest(matrix, k);
        System.out.println(smallest);
    }
    private static int kthsmallest(int[][] matrix, int k) {
        //brute
//        int row = matrix.length;
//        int col = matrix[0].length;
//        int[] arr = new int[row * col];
//        int index = 0;
//        for(int i=0; i<row; i++) {
//            for(int j=0; j<col; j++) {
//
//                arr[index++] = matrix[i][j];
//            }
//        }
//        Arrays.sort(arr);
//        return arr[k-1];
        //optimized
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];


        while(left<right) {
            int mid = left + (right - left) / 2;

            int count = countLessequal(matrix, mid);

            if(count<k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private static int countLessequal(int[][] matrix , int mid) {
        int n = matrix.length;

        int row = n-1;
        int col = 0;
        int count = 0;
        while(row>=0 && col<n) {
            if(matrix[row][col] <= mid) {
                count+=row+1;
                col++;
            } else {
                row--;
            }
        }
        return count;
    }
}
