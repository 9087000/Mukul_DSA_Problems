package DSASheet.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String args[]) {
        int n = 4;
        List<List<String>>  queens = Nqueen(n);
        System.out.println(queens);
    }
    //brute
    //place one queen per row
    // for every row, try every column
    // Before placing check board every time and it is valid
    // result = []
    // board  = new char[n][n]
    // for i from 0 to n - 1:
    //  Arrays.fill(board[i], '.')
    // solve(0, board , result)
    // return result
    // solve(int row , board, result) :
    // if(row == board.length) :
    // result.add(buildBoard(board))
    // return
    // for col from 0 to board.length - 1 :
    // if(isValid(board, row, col) :
    //  place q
    // board[row][col] = 'Q'
    // recurse row + 1
    // solve(row + 1, board, result)
    // place .
    // Same col upwards
    // upper-right digonal
    // upper -left digonal
    // why upward
    // we are placing Queeen every row
    // isValid(board, row, col) :
    // n = board.length
    // for i to row-1 to 0 :
    // for(int i=row-1; i>=0; i--) :
    // if(board[i][col] == 'Q'):
    // false
    // int r = r - 1
    // int c = c - 1
    // while(r>=0 && c>=0) :
    // if(board[r][c] == 'Q'):
    // false
    // r--;
    // c--
    // r = r - 1
    // c = c + 1
    // while(r>=0 && c<n):
    // if(board[r][c] == 'Q')
    // false
    // r--;
    // c++
    // true
    // buildBoard(board)
    // list = []
    // for char[] row : board :
    // add the new string of row to list
    // return list
    // T.C : o(n! * n) i.e o(n!)
    // S.C : o(n^2)
  //    private static List<List<String>> Nqueen(int n) {
//        List<List<String>> result = new ArrayList<>();
//        char[][] board = new char[n][n];
//
//        for(int i=0; i<n; i++) {
//            Arrays.fill(board[i], '.');
//        }
//        solve(0, board, result);
//
//        return  result;
//    }
//
//    private static void  solve(int row, char[][] board, List<List<String>> result) {
//        if(row == board.length) {
//            result.add(buildBoard(board));
//            return;
//        }
//
//        for(int col=0 ;col < board.length; col++) {
//            if(isValid(board, row, col)) {
//                board[row][col] = 'Q';
//                solve(row + 1, board, result);
//                board[row][col] = '.';
//            }
//        }
//    }
//
//    private static boolean isValid(char[][] board, int row, int col) {
//        int n = board.length;
//
//        for(int i=row-1; i>=0; i--) {
//            if(board[i][col] == 'Q') {
//                return false;
//            }
//        }
//
//        int r = row - 1;
//        int c = col - 1;
//
//        while(r >=0 && c >=0) {
//            if(board[r][c] == 'Q') {
//                return false;
//            }
//            r--;
//            c--;
//        }
//
//         r = row - 1;
//         c = col + 1;
//
//         while(r>=0 && c<n) {
//             if(board[r][c] == 'Q') {
//                 return false;
//             }
//             r--;
//             c++;
//         }
//
//         return true;
//    }
//
//    private static List<String> buildBoard(char[][] board) {
//        List<String> list = new ArrayList<>();
//
//        for(char[] row : board) {
//            list.add(new String(row));
//        }
//
//        return list;
//
//    }
    //optimized
    //Avoid scanning board every time
    // check every column and diagonal is o(1)
    // result = []
    // board = new char[n][n]
    // for i from 0 to board.length:
    // Arrays.fill(board[i] , '.')
    // col = boolean[n]
    // left = boolean[2*n-1]
    // right = boolean[2*n-1]
    // solve(0, board, col, left, right, result, n)
    // result
    // solve(row, board, col, left, right, result, n)
    // if(row == board.length) :
    // result add the buildboard(board)
    // return
    // for cols from 0 to board.length:
    // leftDig = row - col + n  -1
    // rightDig = row + col
    // if cols[col] || left[leftDig] || right[rightDig] if any one of true
    // then it is unsafe
    // board[row][cols] = 'Q'
    // cols[col] = true
    // left[leftDig] = true
    // right[rightDig] = true
    // solve(row, board,col, left, right, result, n)
    // board[row][cols] = '.'
    // cols[col] = false
    // left[leftDig] = false
    // right[rightDig] = false
    // buildboard(board) :
    // list = []
    // for row : board:
    // add the new string of row to list
    // return list
    // T.C : o(n! * n) i.e o(n!)
    // S.C : o(n ^ 2)
    public static List<List<String>> Nqueen(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for(int i=0; i<board.length; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] col = new boolean[n];
        boolean[] left = new boolean[2 * n - 1];
        boolean[] right = new boolean[2 * n - 1];

        solve(0, board, result, col, left, right, n);

        return result;
    }

    private static void solve(int row, char[][] board, List<List<String>> result , boolean[] col, boolean[] left, boolean[] right, int n) {
        if(row == board.length) {
            result.add(buildBoard(board));
            return;
        }

        for(int cols=0; cols<n; cols++) {
            int rowval = row - cols + n - 1;
            int colval = row + cols;

            if(col[cols] || left[rowval] || right[colval]) {
                continue;
            }

            board[row][cols] = 'Q';
            col[cols] = true;
            left[rowval] = true;
            right[colval] = true;

            solve(row + 1, board, result, col, left, right, n);

            board[row][cols] = '.';
            col[cols] = false;
            left[rowval] = false;
            right[colval] = false;

        }
    }

    private static List<String> buildBoard(char[][] board) {
        List<String> list = new ArrayList<>();
        for(char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }
}
