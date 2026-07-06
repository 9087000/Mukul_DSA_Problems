package DSASheet.Grpahs;

public class Maxareaofisland {
    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        int maxArea = maxAreaOfIsland(grid);

        System.out.println(maxArea);
    }
    //optimized
    // Avoid visited[][]
    // Mark the visited land directly in grid
    // grid[row][col] == 0
    // maxArea = 0
    // Traverse cell
    // if grid[row][col] == 1
    // start Dfs
    // Traverse Dfs convert the 1 to 0s of land
    // dfs return area
    // update maxArea
    // return maxArea
    // dfs
    // if outof bounds
    // return 0
    // grid[row][col] == 0
    // return 0
    // grid[row][col] == 0
    // return 1 + dfs(row + 1, col, grid)
    //          + dfs(row - 1, col, grid)
    //          + dfs(row, col + 1, grid)
    //          + dfs(row, col - 1, grid)
    // T.C: o( m * n )
    // S.C : o(1)
    private static int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int maxArea = 0;

        for(int row=0; row<rows; row++) {
            for(int col=0; col<cols; col++) {
                if(grid[row][col] == 1) {
                    int area = dfs(row, col, grid);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private static int dfs(int row, int col, int[][] grid) {
        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;

        return 1 + dfs(row + 1, col, grid)
                 + dfs(row - 1, col, grid)
                 + dfs(row, col + 1, grid)
                + dfs(row, col - 1, grid);
    }
     //brute
    // Use visited[][] array to avoid counting same land cell again
    // visited[][]
    // create visited[][] array of grid.length and grid[0].length
    // maxArea = 0
    // traverse cell
    // if grid[row][col] == 1 and !visited[row][col]
    // start dfs
    // dfs return the area of the island
    // update maxArea
    // return maxArea
    // dfs
    // out of bound
    // return 0
    // grid[row][col] == 0
    // return 0
    // visited[row][col]
    // return 0
    // visited[row][col] == true
    //  explore all four directions
    // T.C : o(m * n)
    // S.C: o(m * n)
//    private static int maxAreaOfIsland(int[][] grid) {
//        int rows = grid.length;
//        int cols = grid[0].length;
//
//        boolean[][] visited = new boolean[rows][cols];
//
//        int maxArea = 0;
//
//        for(int row=0; row<rows; row++) {
//            for(int col=0; col<cols; col++){
//                if(grid[row][col] == 1 && !visited[row][col]) {
//                    int area = dfs(row, col, grid, visited);
//                    maxArea = Math.max(maxArea, area);
//                }
//            }
//        }
//
//        return maxArea;
//    }
//    private static int dfs(int row, int col, int[][] grid, boolean[][] visited) {
//        if(row<0 || col<0 || row>=grid.length || col>=grid[0].length || grid[row][col] == 0 || visited[row][col]) {
//            return 0;
//        }
//
//        visited[row][col] = true;
//
//        return 1
//                + dfs(row + 1, col, grid, visited)
//                + dfs(row - 1, col, grid, visited)
//                + dfs(row, col + 1, grid, visited)
//                + dfs(row, col - 1, grid, visited);
//    }
}
