package DSASheet.BinarySearch;

public class SearchA2DMatrixII {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {8,21,23,26,30}};
        int target = 5;
        boolean search = searchA2D(matrix, target);
        System.out.println(search);
    }
    private static boolean searchA2D(int[][] matrix, int target) {
        //brute
//        int m = matrix.length;
//        int n = matrix[0].length;
//
//        for(int i=0; i<m; i++) {
//            for(int j=0; j<n; j++) {
//                if(matrix[i][j] == target) {
//                    return true;
//                }
//            }
//        }
//        return false;
        //optimized
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n  - 1;

        while(row<m && col >=0) {

            if(matrix[row][col] == target) {
                return  true;
            } else if(matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }
}
