package DSASheet.Grpahs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5}, {3,2,3,4,4}, {2,4,5,3,1}, {6,7,1,4,5}, {5,1,1,2,4}};
        List<List<Integer>> pacific = pacificAtlanticWater(heights);
        for(List<Integer> cell : pacific) {
            System.out.println(cell);
        }
    }
    //optimized
    // Create
    // pacific[][]
    // atlantic[][]
    // start dfs from pacific boundaries
    // Top Row
    // left
    // Mark all cells as pacific
    // start dfs from atlantic bounaries
    // bottom
    // right
    // Mark all cells as atlantic
    // Reverse the entire grid
    // new Height >= currentHeight
    // if
    // pacific[row][col] && altanic[row][col]
    // matches add answwr
    // return answer
    // T.C : o(m * n)
    // S.C : o(m * n)
    // rows = heights.length
    // cols = heights[0].length
    // pacific[][] = new boolean[rows][cols]
    // atlantic[][] = new boolean[rows][cols]
    // for row from 0 to rows
    // dfs(row, 0, heights, pacific)
    // for col from 0 to cols
    // dfs(0, col, heights, pacific)
    // for row from 0 to rows
    // dfs(row, cols - 1, heights, atlantic)
    // for col from 0 to cols
    // dfs(rows - 1, col, heights, atlantic)
    // for row from 0 to rows:
    // for col from 0 to cols:
    // if(pacific[row][col] && atlantic[row][col] )
    // result.add(Arrays.asList(row,col));
    // return result
    // dfs(row, col, heights, boolean[][] visited):
    // if(visited[row][col])
    // return;
    // visited[row][col] = true
    // int[][] dirs = {{1,0},{-1,0}, {0,-1},{0,1}}
    // for int[] dir : dirs:
    // nr = row + dir[0]
    // nc = col + dir[1]
    // if nr>=0 && nc>=0 && nr<heights.length && nc<heights[0].length && !visited[nr][nc] && heights[nr][nc] >= heights[row][col]
    // dfs(nr,nc, heights, visited)
    private static List<List<Integer>> pacificAtlanticWater(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pacific = new  boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int col=0; col<cols; col++) {
            dfs(0, col, heights, pacific);
        }

        for(int row=0; row<rows; row++) {
            dfs(row, 0, heights, pacific);
        }

        for(int col=0;col<cols; col++) {
            dfs(rows-1, col, heights, atlantic);
        }

        for(int row=0;row<rows; row++) {
            dfs(row, cols-1, heights, atlantic);
        }
        for(int row=0; row<rows; row++) {
            for(int col=0; col<cols; col++) {
                if(pacific[row][col] && atlantic[row][col]) {
                    result.add(Arrays.asList(row, col));
                }
            }
        }

        return result;
    }

    private static void  dfs(int row, int col, int[][] heights, boolean[][] visited) {
        if(visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        int[][] dirs = {{1,0},{-1,0}, {0,1}, {0,-1}};
        for(int[] dir : dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if(nr>=0 && nc>=0 && nr<heights.length && nc<heights[0].length && !visited[nr][nc] && heights[nr][nc] >= heights[row][col]) {
                dfs(nr,nc, heights, visited);
            }
        }
    }
    //brute
    // Intialize result List<List<Integer>> as new ArrayList
    // rows = heights.length
    // cols = heights[0].length
    // Traverse every cell
    // for row from 0 to rows - 1:
    // for col from 0 to cols - 1:
    // check whether if the cell can reach pacific
    // check whether if the cell can reach atlantic
    // DFS moves to lower/ equal height
    // nextHeight <= currentHeight
    // can reachPacific(row, col, heights, new boolean[rows][col])
    // can reachAtlantic(row, col, heights, new boolean[rows[cols])
    // if the both pacific && atlantic reachable
    // add the answer to result
    // result.add(Arrays.asList(row,col))
    // return result
    // T.C : o((m*n) ^2)
    // S.C: o(m*n)
    // canReachPacific(row, col, heights, boolean[][] visited)
    // if(row == 0 || col == 0)
    // return true
    // visited[row][col] = true
    // int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}}
    // for int[] dir in dirs:
    // nr = row + dir[0]
    // nc = col + dir[1]
    // if nr>=0 && nc>=0 && nr<heights.length && nc<heights[0].length && !visited[nr][nc] && heights[nr][nc] <= heights[row][col] :
    // if(canReachPacific(nr,nc, heights, visited):
    // return true
    // return false
    // canReachAtlantic(row, col, heights, boolean[][] visited):
    // row == heights.length || col == heights[0].length - 1
    // return true
    // visited[row][col] = true
    // int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}}
    // for int[] dir in dirs:
    // nr = row + dir[0]
    // nc = col + dir[1]
    // if nr>=0 && nc>=0 && nr<heights.length && nc<heights[0].length && !visited[nr][nc] && heights[nr][nc] <= heights[row][col] :
    // if(canReachAtlantic(nr,nc, heights, visited):
    // return true
    // return false
//    private static List<List<Integer>> pacificAtlanticWater(int[][] heights) {
//        List<List<Integer>> result = new ArrayList<>();
//        int rows = heights.length;
//        int cols = heights[0].length;
//
//
//        for(int row=0; row<rows; row++) {
//            for(int col=0; col<cols; col++) {
//                boolean reachPacific = canReachPacific(row, col, heights, new boolean[rows][cols]);
//                boolean reachAtlantic = canReachAtlantic(row,col, heights, new boolean[rows][cols]);
//                if(reachAtlantic && reachPacific) {
//                    result.add(Arrays.asList(row, col));
//                }
//            }
//        }
//
//        return result;
//    }
//    private static boolean canReachPacific(int row, int col, int[][] heights, boolean[][] visited) {
//        if(row == 0 || col == 0) {
//            return true;
//        }
//
//        visited[row][col] = true;
//        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
//        for(int[] dir: dirs) {
//            int nr = row + dir[0];
//            int nc = col + dir[1];
//
//            if(nr>=0 && nc>=0 && nr<heights.length && nc<heights[0].length && !visited[nr][nc] && heights[nr][nc]<=heights[row][col]) {
//                if(canReachPacific(nr,nc, heights, visited)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    private static boolean canReachAtlantic(int row, int col, int[][] heights, boolean[][] visited) {
//        if(row == heights.length - 1 || col == heights[0].length - 1) {
//            return true;
//        }
//
//        visited[row][col] = true;
//        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
//        for(int[] dir: dirs) {
//            int nr = row + dir[0];
//            int nc = col + dir[1];
//
//            if(nr>=0 && nc>=0 && nr<heights.length && nc<heights[0].length && !visited[nr][nc] && heights[nr][nc] <= heights[row][col]) {
//                if(canReachAtlantic(nr, nc, heights, visited)) {
//                    return true;
//                }
//            }
//        }
//
//        return false;
//    }
}
