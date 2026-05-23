package DSASheet.BinarySearch;

public class SerachMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20}, {23,30,34,60}};
        int target = 13;
        boolean matrixValue = searchMatrix(matrix, target);
        System.out.println(matrixValue);
    }
    private static boolean searchMatrix(int[][] matrix , int target) {
        //brute
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//        for(int i=0; i<rows; i++) {
//            for(int j=0; j<cols; j++) {
//                if(matrix[i][j] == target) {
//                    return true;
//                }
//            }
//        }
//        return false;
        int row = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = row * cols - 1;

        while(left<=right) {
            int mid = left + (right - left) / 2;

            int r = mid / cols;
            int c = mid % cols;

            if(matrix[r][c] == target) {
                return true;
            } else if(matrix[r][c] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
