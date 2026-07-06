package DSASheet.Grpahs;

import java.util.ArrayList;
import java.util.List;

public class NumberOfenaclaves {
//    private static boolean isboundaryTouched;
    public static void main(String[] args) {
        int[][] grid = {{0,0,0,0}, {1,0,1,0}, {0,1,1,0}, {0,0,0,0}};
        int enclaves = numberOfEnaclaves(grid);
        System.out.println(enclaves);
    }
    //optimized
    // Traverse Boundary cells
    // if the Boundary cells is 1 run the dfs
    // in the dfs convert all boundary connected 1 to 0s
    // Traverse the entire grid
    // Count all remaining 1s
    // return count
    // t.c: o(m * n)
    // s.c: o(1)
    // rows = grid.length
    // cols = grid[0].length
    // for int col from 0 to cols
    // dfs(0, col, grid)
    // dfs(rows-1, col, grid)
    // for int row from 0 to rows
    // dfs(row, 0, grid)
    // dfs(row, cols - 1, grid)
    // count = 0
    // for int row from 0 to rows
    // for int col from 0 to cols
    // if grid[row][col] == 1
    // count++
    // return count
    // dfs(row, col, grid)
    // if(row<0 || col < 0 || row>=grid.length || col>=grid[0].length || grid[row][col] = 0
    // return
    // grid[row][col] = 0
    // dfs(row + 1, col, grid)
    // dfs(row - 1, col, grid)
    // dfs(row, col + 1, grid)
    // dfs(row, col - 1, grid)
    private static int numberOfEnaclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for(int col=0;col<cols; col++) {
            dfs(0, col, grid);
            dfs(rows-1, col, grid);
        }

        for(int row=0;row<rows;row++) {
            dfs(row, 0, grid);
            dfs(row, cols-1, grid);
        }

        int count = 0;
        for(int row=0; row<rows; row++) {
            for(int col=0; col<cols; col++) {
                if(grid[row][col] == 1) {
                    count++;
                }
            }
        }

        return count;

    }

    private static void dfs(int row, int col, int[][] grid) {
        if(row<0||col<0 || row>=grid.length || col>=grid[0].length || grid[row][col] == 0) {
            return;
        }
        grid[row][col] = 0;
        dfs(row + 1, col, grid);
        dfs(row - 1, col, grid);
        dfs(row, col + 1, grid);
        dfs(row, col - 1, grid);
    }
    //brute
    // Create visited[][]
    // Traverse the every/entire grid
    // If the cell is 1 and not visited run the dfs
    // DFS, count the islandSize
    // in the dfs check whether island touches boundary
    // if it not touches boundary ,  add the island size to answer
    // return answer
    // t.c: o(m * n)
    // S.c: o(m * n)
    // private static boolean isTouchBoundary
    // rows = grid.length
    // cols = grid[0].length
    // boolean[][] visited = new boolean[rows][cols]
    // ans = 0
    // for int row from 0 to rows
    // for int col from 0 to cols
    // if grid[row][col] = 1 && !visitied[row][col]
    // int islandSize = dfs(row, col, grid, visited)
    // if(!isTouchBoundary)
    // answer+=islandSize
    // return answer
    // dfs(row, col, grid, visited)
    // if(row < 0 || col < 0 || row>=grid.length || col>=grid[0].length || visited[row][col] || grid[row][col] = 0)
    // return 0
    // visited[row][col] = true
    // if(row == 0 || col == 0 || row == grid.length || col == grid[0].length - 1 )
    // isTouchBoundary = true
    // return 1 + dfs(row + 1, col, grid, visited)
    //          + dfs(row - 1, col, grid, visited)
    //          + dfs(row, col + 1, grid, visited)
    //          + dfs(row, col - 1, grid, visited)
//    private static int numberOfEnaclaves(int[][] grid) {
//        int rows = grid.length;
//        int cols = grid[0].length;
//
//        boolean[][] visited = new boolean[rows][cols];
//        int answer = 0;
//        for(int row=0; row<rows; row++) {
//            for(int col=0; col<cols; col++) {
//                if(grid[row][col] == 1 && !visited[row][col]) {
//                    isboundaryTouched = false;
//
//                   int islandSize =  dfs(row, col, grid, visited);
//
//                   if(!isboundaryTouched) {
//                       answer += islandSize;
//                   }
//                }
//            }
//        }
//        return answer;
//    }
//
//    private static int dfs(int row, int col, int[][] grid ,boolean[][] visited) {
//        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || visited[row][col] || grid[row][col] == 0) {
//            return 0;
//        }
//
//        visited[row][col] = true;
//        if(row==0 || col==0 || row==grid.length - 1 || col==grid[0].length - 1) {
//            isboundaryTouched = true;
//        }
//
//        return 1 + dfs(row + 1 , col, grid,  visited)
//                 + dfs(row - 1, col, grid, visited)
//                 + dfs(row, col + 1, grid, visited)
//                 + dfs(row, col - 1, grid, visited);
//    }
}
