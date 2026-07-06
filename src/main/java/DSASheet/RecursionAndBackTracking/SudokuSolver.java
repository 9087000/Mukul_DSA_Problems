package DSASheet.RecursionAndBackTracking;

import java.util.Arrays;

public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'} ,{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'}, {'7','.','.','.','2','.','.','.','6'} ,{'.','6','.','.','.','.','2','8','.'}, {'.','.','.','4','1','9','.','.','5'}, {'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);

        for(char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
    //optimized
    // check row, col, 3*3 box before placing digit
    // Find first empty cell
    // Try digit from 1 to 9
    // Before placing check :
    // row is valid
    // col is valid
    // 3*3 box is valid
    // if valid :
    // place digit
    // Recurse for next empty cell
    // if solve return true:
    // true
    // else undo:
    // board[row][col] = '.'
    // if no digit works:
    // false
    // if there is no empty cell:
    // true
    // T.C : o(9^e)
    // S.C : o(E)
    // solve(board):
    // solve(board) :
    // for row from 0 to 9 :
    // for col from 0 to 9 :
    // if board[row][col] == '.'
    // for digit = '1'  digit<='9' digit++
    // if(isValid(board, row, col,digit) :
    // board[row][col] = digit
    // if solve(board)
    // true
    // board[row][col] = '.'
    // return false
    // true
    // isValid(board, row, col, digit) :
    // for i from 0 to 9 :
    // if board[row][i]
    // false
    // if board[i][col] :
    // false
    // boardrow = row * (3 /row) + i / 3
    // boardcol = col * (3/col) + i % 3
    // if board[boardrow][boardcol]
    // false
    // true
    private static void solveSudoku(char[][] board) {
        solve(board);
    }
    private static boolean solve(char[][] board) {
        for(int row=0; row<9; row++) {
            for(int col=0;col<9;col++) {
                if(board[row][col] == '.') {
                    for(char digit='1'; digit<='9'; digit++) {
                        if(isValid(board, row, col, digit)) {
                        board[row][col] = digit;
                            if(solve(board)) {
                                return true;
                            }
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int row , int col, char digit) {
        for(int i=0; i<9; i++) {
            if(board[row][i] == digit) {
                return false;
            }
            if(board[i][col] == digit) {
                return false;
            }
            int bowrow = 3 * (row /3 ) + i / 3;
            int boxcol = 3 * (col / 3) + i%3;

            if(board[bowrow][boxcol] == digit) {
                return false;
            }
        }
        return true;
    }

    //brute
    // place digit first
    // then validate the whole board
    // Find first empty cell
    // Try digit from '1' to '9'
    // place digit in empty cell
    // check entire board :
    // row valid
    // col valid
    // 3*3 valid
    // if the board is valid :
    // solve the board
    // if solve returns true:
    // true
    // else undo
    // board[row][col] == '.'
    // if there is no digit works:
    // false
    // if there is no empty cell remains:
    // true
    //  T.C : o(9^E * 81)
    // S.C : o(E)
    // solve(board)
    // solve(board) :
    // for row from 0 to 9 :
    // for col from 0 to 9 :
    // if board[row][col] == '.'
    // for char digit ='1' digit <= '9' digit++
    // board[row][col] = digit
    // if build board(board)) :
    // solve(board) :
    // true
    // board[row][col] = '.'
    // true
    // buildBoard(board) :
    // for row from 0 to 9 :
    // boolean[] seen = new boolean[10]
    // for col from 0 to 9 :
    // if board[row][col] continue
    // index = board[row][col] - '0'
    // if(seen[index]) false
    // seen[index] = true
    // for col from 0 to 9:
    // seen = new boolean[10]
    // for row 0 to 9 :
    // if board[row][col] continue
    // index = board[row][col] - '0'
    // if seen[index] return false
    // seen[index] = true
    // for rowBox from 0 to 9 , rowBox+=3:
    // for rowCol from 0 to 9 , rowCol+=3:
    // seen = [10]
    // for r from rowBox to 9
    // for c from rowCol to 9
    // if board[r][c] continue
    // index = board[r][c] - '0'
    //  if seen[index] false
    // seen[index] = true
    // true
//    private static void solveSudoku(char[][] board) {
//      solve(board);
//    }
//    private static boolean solve(char[][] board) {
//        for(int row=0; row<9; row++) {
//            for(int col=0; col<9; col++) {
//                if(board[row][col] == '.') {
//                    for(char digit='1'; digit<='9'; digit++) {
//                        board[row][col] = digit;
//
//                        if(isBoardValid(board)) {
//                            if(solve(board)) {
//                                return true;
//                            }
//                        }
//                        board[row][col] = '.';
//                    }
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    private static boolean isBoardValid(char[][] board) {
//        for(int row=0; row<9; row++) {
//            boolean[] seen = new boolean[10];
//
//            for(int col=0; col<9; col++) {
//                if(board[row][col] == '.') continue;
//
//                int digit = board[row][col] - '0';
//
//                if(seen[digit]) return false;
//
//                seen[digit] = true;
//            }
//        }
//
//        for(int col=0; col<9; col++) {
//            boolean[] seen = new boolean[10];
//
//            for(int row=0; row<9; row++) {
//                if(board[row][col] == '.') continue;
//
//                int digit = board[row][col] - '0';
//
//                if(seen[digit]) return false;
//
//                seen[digit] = true;
//            }
//        }
//
//        for(int rowbox=0; rowbox<9; rowbox+=3) {
//            for(int rowcol=0; rowcol<9; rowcol+=3) {
//                boolean[] seen = new boolean[10];
//
//                for(int r=rowbox; r<rowbox+3;r++) {
//                    for(int c=rowcol; c<rowcol+3; c++) {
//                        if(board[r][c] == '.') continue;;
//
//                        int digit = board[r][c] - '0';
//
//                        if(seen[digit]) return false;
//
//                        seen[digit] = true;
//                    }
//                }
//            }
//        }
//
//        return true;
//    }
}
