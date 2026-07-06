package DSASheet.Grpahs;

import java.util.ArrayList;
import java.util.List;

public class SurrondedRegions {
    public static void main(String[] args) {
        char[][] board = {{'X', 'X','X','X'}, {'X','O','O','X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solve(board);
        for(int row=0;row<board.length; row++) {
            for(int col=0;col<board[0].length; col++) {
                System.out.print(board[row][col] + " ");
            }
        }
        System.out.println();
    }
    //brute
    // create visited array
    // Traverse Every cell
    // if the cell is O and not visited , then start DFS
    // in the DFS collects all O into region list
    // Check any cell in region touches boundary , if it not touches boundary convert all to X
    // If the region touches boundary , keep the O as it is
    // T.C : o(m*n)
    // S.C:o(m*n)
    // rows = board.length
    // cols = board[0].length
    // boolean[][] visited = new boolean[rows][cols]
    // for row from 0 to rows :
    // for col from 0 to cols :
    // if board[row][col] && !visited[row][col]:
    // List<int[]> region = new ArrayList<>()
    // boolean[] isBoundaryTouched = new boolean[1]
    // dfs(row, col, board, region, isBoundaryTouched, visited)
    // if(!isBoundaryTouched[0])
    // for int[] cell:region :
    // board[cell[0]][cell[1]] = 'X'
    // dfs(row, col, board, region, isBoundaryTouched, visited):
    // if (row<0 || col<0 || row>=board.length || col>= board[0].length || visited[row][col] || board[row][col] != 'O')
    // return
    // visited[row][col] = true
    // region.add(new int[]{row,col})
    // if (row == 0 || col == 0 || row == board.length - 1 || col == board[0].length - 1 )
    // isBoundaryTouched[0] = true
    // dfs(row + 1 , col, board, region , isBoundaryTouched, visited)
    // dfs(row - 1, col, board, region , isBoundaryTouched, visited)
    // dfs(row, col + 1, board, region, isBoundaryTouched, visited)
    // dfs(row, col - 1, board, region, isBoundaryTouched, visited)
    private static void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for(int row=0;row<rows;row++) {
            for(int col=0;col<cols; col++) {
                if(board[row][col] == 'O' && !visited[row][col]) {
                    List<int[]> region = new ArrayList<>();
                    boolean[] isBoundaryTouched = new boolean[1];

                    dfs(row,col, board, region, visited, isBoundaryTouched);

                    if(!isBoundaryTouched[0]) {
                        for(int[] cell : region) {
                            board[cell[0]][cell[1]] = 'X';
                        }
                    }
                }
            }
        }
    }

    private static void dfs(int row, int col, char[][] board, List<int[]> region, boolean[][] visited, boolean[] istouched) {
        if(row<0 || col<0 || row>=board.length || col>=board[0].length || visited[row][col] || board[row][col] != 'O') {
            return;
        }

        visited[row][col] = true;
        region.add(new int[]{row,col});
        if(row == 0 || col == 0 || row==board.length -1 || col == board[0].length-1) {
            istouched[0]= true;
        }

        dfs(row+1, col, board, region, visited, istouched);
        dfs(row-1, col, board, region, visited, istouched);
        dfs(row, col + 1, board, region, visited, istouched);
        dfs(row, col-1, board, region, visited, istouched);

    }
//    //optimized
      // Traverse only boundary cells
      // If the boundary cell is O start DFS
      // DFS Marks all the O cells as #
    // Traverse full board
    // Convert all remaining O to X
    // Convert all the # to O
    // T.C : o(m * n)
    // S.C: o(1)
    // worst case for recursion : o(m * n)
    // rows = board.length
    // cols = board[0].length
    // for col from 0 to cols :
    // dfs(0, col, board)
    // dfs(rows + 1, col, board)
    // for row from 0 to rows:
    // dfs(row, 0, board)
    // dfs(row, cols + 1, board)
    // for row from 0 to rows:
    // for col from 0 to cols:
    // if board[row][col] == 'O'
    // board[row][col] = 'X'
    // else if board[row][col] == '#'
    // board[row][col] = 'O'
    // dfs(row, col, board)
    // if row <0 || col<0 || row>=board.length || col>=board[0].length || board[row][col] != 'X'
    // return
    // board[row][col] = '#'
    // dfs(row + 1, col, board)
    // dfs(row - 1, col, board)
    // dfs(row, col + 1, board)
    // dfs(row, col - 1, board)
//    private static void solve(char[][] board) {
//        int rows = board.length;
//        int cols = board[0].length;
//
//        for(int col=0; col<cols;col++) {
//                dfs(0, col, board);
//                dfs(rows-1, col, board);
//        }
//
//        for(int row=0;row<rows;row++) {
//            dfs(row, 0,  board);
//            dfs(row,cols-1,  board);
//        }
//
//        for(int row=0;row<rows;row++) {
//            for(int col=0; col<cols; col++) {
//                if(board[row][col] == 'O') {
//                    board[row][col] = 'X';
//                } else if(board[row][col] == '#') {
//                    board[row][col] = 'O';
//                }
//            }
//        }
//    }
//
//    private static void dfs(int row, int col, char[][] board) {
//        if(row<0 || col<0 || row>=board.length || col>=board[0].length || board[row][col] != 'O') {
//            return;
//        }
//
//        board[row][col] = '#';
//        dfs(row +1, col, board);
//        dfs(row-1, col, board);
//        dfs(row, col+1, board);
//        dfs(row, col-1, board);
//    }
}
