package DSASheet.Grpahs;

public class NumberOfISlands {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};
        int island = numberOfIslands(grid);
        System.out.println(island);
    }
    //optimized
    // no Visited[][]
    // Instead, directly mark visited land as water
    // grid[row][col] == '0'
    // island = 0
    // for every cell in grid of row and col
    // if grid[row][col] == '1'
    // island++
    // start dfs
    // Traverse all connected lands '1' s to '0'
    // continue scanning
    // return island
    // dfs
    // if out of bounds
    // return
    // if grid[row][col] == '0'
    // return
    // grid[row][col] == '0'
    // explore all four directions
    // T.C : o(rows * cols)
    // S.C ; o(1)
    // island = 0
    // for row from 0 to grid.length
    // for col from 0 to grid[0].length
    // island++
    // dfs(row, col, grid)
    // if(row<0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0' :
    // return
    // grid[row][col] == '0'
    // dfs(row + 1, col, grid)
    // dfs(row - 1, col, grid)
    // dfs(row, col + 1, grid)
    // dfs(row, col  - 1, grid)
    private static int numberOfIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int island = 0;

        for(int row=0; row<rows; row++) {
            for(int col=0; col<cols; col++) {
                if(grid[row][col] == '1') {
                    island++;
                    dfs(row, col, grid);
                }
            }
        }

        return island;
    }

    private static void dfs(int row, int col, char[][] grid) {
        if(row<0 || col<0 || row>=grid.length || col>= grid[0].length || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';
        dfs(row + 1, col, grid);
        dfs(row - 1, col, grid);
        dfs(row, col + 1, grid);
        dfs(row, col - 1, grid);
    }
    //brute
    // Use seperate visited[][] cell
    // 1 means land
    // 0 means water
    // We consider as one land for unvisited cell
    // create visited array of size grid.length and grid[0].length
    // island = 0
    // Traverse cell in grid
    // if the grid[row][col] == 1 and not visited cell
    // island++
    // start DFS for every cell
    // Dfs marks all connect and land cells as visited
    // Scan again
    // return island
    // Dfs
    // out of boundray
    // return
    // if grid[row][col] == '0'
    // return
    // visited[row][col]
    // return
    // marked vistied cell as true
    // explore all four directions
    // row +1 , col
    // row - 1, col
    // row, col + 1
    // row, col - 1
    // T.C : o(row * col)
    // S.C : o( row * cols)
    // rows = grid.length
    // cols = grid[0].length
    // visitied[][] = new boolean[rows][cols]
    // int island = 0
    // for row from 0 to rows:
    // for col from 0 to cols:
    // if grid[row][col] == '1' && !visitied[row][col]:
    // island++
    // dfs(row, col, grid, visitied)
    // return island
    // dfs(row, col, grid, visitied) :
    // if(row<0||col<0|| row>=grid.length || col >= grid[0].length || grid[row][col] == '0' || visitied[row][col]) :
    // return
    // visitied[row][col] = true
    // dfs(row + 1, col, grid, visitied)
    // dfs(row - 1, col, grid, visitied)
    // dfs(row, col + 1, grid, visitied)
    // dfs(row, col - 1, grid, visitied)
//    private static int numberOfIslands(char[][] grid) {
//        int rows = grid.length;
//        int cols = grid[0].length;
//
//        boolean[][] visited = new boolean[rows][cols];
//        int island = 0;
//
//        for(int row=0; row<rows; row++) {
//            for(int col=0; col<cols; col++) {
//                if(grid[row][col] == '1' && !visited[row][col]) {
//                    island++;
//                    dfs(row, col, grid, visited);
//                }
//            }
//        }
//
//        return island;
//    }
//
//    private static void dfs(int row, int col, char[][] grid, boolean[][] visited) {
//        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col] == '0' || visited[row][col]) {
//            return;
//        }
//
//        visited[row][col] = true;
//
//        dfs(row + 1, col, grid, visited);
//        dfs(row - 1, col, grid, visited);
//        dfs(row, col + 1, grid, visited);
//        dfs(row, col - 1, grid, visited);
//
//    }
}
