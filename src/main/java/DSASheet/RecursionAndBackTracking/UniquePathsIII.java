package DSASheet.RecursionAndBackTracking;

public class UniquePathsIII {
    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0}, {0,0,0,0}, {0,0,2,-1}};
        int unique = uniquePathsIII(grid);
        System.out.println(unique);
    }
    //optimized
    // instead of extra visited mark visited directly in grid
    // int temp = grid[row][col]
    // grid[row][col] = -1
    // After recursion grid[row][col] = temp
    // find the start cell
    // count walking cell
    // 1 and all 0 empty cells
    // start DFs
    // if invalid :
    // return 0
    // if it is 2:
    // return walkingCells = 1 if it is walkingCells == 0
    // else return 0
    // Store current cell valuve in temp
    // mark the cell as visited if grid[row][col] = -1
    // reduce the walkingcells
    // explore four direction
    // restore the value grid[row][col] = temp
    // return paths
    // T.C : o(4^k)
    // S.C : o(k)
    // startRow = 0
    // startCol = 0;
    // walkingCells = 0
    // for row from 0 to grid.length - 1 :
    // for col from 0 to grid[0].length - 1:
    // if grid[row][col] == 1
    // startRow = row
    // startCol = col
    // walkingCells++
    // if grid[row][col] == 0
    // walkingCells++
    // return solve(startRow, startCol, walkingCells, grid)
    // solve(row, col, walkingCells, grid) :
    // if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col] == -1) :
    // return 0
    // if(grid[row][col] == 2):
    // return walkingCells == 0 ? 1 :0
    //  int temp = grid[row][col]
    // grid[row][col] = -1
    // walkingCells--
    // int path = 0
    // path += solve(row + 1, col, walkingCells, grid)
    // path += solve(row-1, col, walkingCells, grid)
    // path += solve(row, col + 1, walkingCells, grid)
    // path += solve(row, col - 1, walkingCells, grid)
    // grid[row][col] = temp
    // return path
    private static int uniquePathsIII(int[][] grid) {
        int startRow = 0;
        int startCol = 0;
        int walkingCells = 0;

        for(int row=0; row<grid.length; row++) {
            for(int col=0; col<grid[0].length; col++) {
                if(grid[row][col] == 1) {
                    startRow = row;
                    startCol = col;
                    walkingCells++;
                }
                if(grid[row][col] == 0) {
                    walkingCells++;
                }
            }
        }

        return solve(startRow, startCol, walkingCells, grid);
    }

    private static int solve(int row, int col, int walkingCells, int[][] grid) {
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col] == -1) {
            return 0;
        }

        if(grid[row][col] == 2) {
            return walkingCells == 0 ? 1 : 0;
        }

        int temp = grid[row][col];
        grid[row][col] = -1;
        walkingCells--;

        int path = 0;
        path += solve(row + 1, col, walkingCells, grid);
        path += solve(row-1, col, walkingCells, grid);
        path += solve(row, col+1, walkingCells, grid);
        path += solve(row, col-1, walkingCells, grid);

        grid[row][col] = temp;

        return path;
    }
    //brute
    // use Visited to keep track of cell  already used
    // Start from 1
    // Reach 2
    // visit 0 every cell exactly once
    // Avoid -1
    // Traverse grid
    // Find the startRow and startCol if the gridVal is 1
    // count walking cells
    // if cell is 0
    // all 0 empty cells
    // Find the dfs
    // visited = new boolean[grid.length][grid[0].length]
    // dfs(startRow, StartCol, walkingCells, grid, visited)
    // if it is invalid :
    // outBounds
    // val is -1
    // visited
    // return 0
    // if grid[row][col] == 2:
    // return 1 if walkingCells == 0
    // else return 0
    // mark cell as visited
    // reduce walingCells
    // path = 0
    // explore four direction
    // backtrack
    // visited[row][col] = false
    // return path
    // T.C : o(4^k)
    // S.C : o(k) + o(m*n)
    // startRow = 0
    // startCol = 0
    // walkingCells = 0
    // for row from 0 to grid.length - 1 :
    // for col from 0 to grid[0].length - 1:
    // if grid[row][col] == 1:
    // startRow = row
    // startCol = col
    // walkingCells++
    // if grid[row][col] == 0 :
    // walkingCells++
    // boolean[][] visited = new boolean[grid.length][grid[0].length]
    // return solve(startRow, startCol, walkingCells, grid, visited)
    // solve(row, col, walkingCells, grid, visited):
    // if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col] == -1 || visited[row][col]) :
    // return 0
    // if grid[row][col] == 2 :
    // return walkingCells == 0 ? 1 : 0
    // visited[row][col] = true
    // walkingCells--
    // int path = 0
    // path += solve(row + 1, col, walkingCells, grid, visited)
    // path += solve(row-1, col, walkingCells, grid, visited)
    // path += solve(row, col + 1, walkingCells, grid, visited)
    // path += solve(row, col-1, walkingCells, grid, visited)
    // visited[row][col] = false
    // return path
//    private static int uniquePathsIII(int[][] grid) {
//        int rows = grid.length;
//        int cols = grid[0].length;
//        boolean[][] visited = new boolean[rows][cols];
//
//        int startRow = 0;
//        int startCol = 0;
//        int walkingCells = 0;
//
//        for(int row=0; row<rows; row++) {
//            for(int col=0; col<cols; col++) {
//                if(grid[row][col] == 1) {
//                    startRow = row;
//                    startCol = col;
//                    walkingCells++;
//                }
//
//                if(grid[row][col] == 0) {
//                    walkingCells++;
//                }
//            }
//        }
//        return solve(startRow,startCol, walkingCells, grid, visited);
//    }
//    private static int solve(int row, int col, int walkingCells, int[][] grid, boolean[][] visited) {
//        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col] == -1 || visited[row][col]) {
//            return 0;
//        }
//
//        if(grid[row][col] == 2 ) {
//            return walkingCells == 0 ? 1 : 0;
//        }
//
//        visited[row][col] = true;
//        walkingCells--;
//        int path = 0;
//        path += solve(row + 1, col, walkingCells, grid, visited);
//        path += solve(row-1, col, walkingCells, grid, visited);
//        path += solve(row, col+1, walkingCells, grid, visited);
//        path += solve(row, col-1, walkingCells, grid, visited);
//
//
//        visited[row][col] = false;
//
//        return path;
//    }
}
