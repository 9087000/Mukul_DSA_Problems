package DSASheet.Grpahs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    public static void main(String[] args) {
        int[][] heights = {{1,2,2}, {3,8,2}, {5,3,5}};
        int minimum = pathwithminimumEffort(heights);
        System.out.println(minimum);
    }
    //optimized
    // Queue is not enought
    // we will use priorityQueue
    // PriorityQueue process
    // minimum effort first
    // first time reaching destination
    // |
    // minimum effort
    // priorityQueue
    // stores
    // effort
    // row
    // col
    // intially
    // effort[0][0] = 0
    // Integer.MAX_VALUE
    // current path
    // |
    //  neighbour edge path
    // Math.abs(currentEdge - neighbourpath)
    // currentEdgepath
    // |
    // newEdgepath
    // max(newEdgepath- currentPath)
    // priorityQueue
    // |
    //  poll current path
    // |
    //  Move 4 directions
    // |
    // destination reached?
    // |
    //  return
    // |
    // calculate current edge effort
    // |
    // calculate max next edge effort
    //  |
    //  if max is less than effort
    //  |
    //  assign it to effort[row][col]
    //  |
    //  push into queue
    // T.C : o(v log v)
    // S.C : o(v)
    // rows = heights.length
    // cols = heights[0].length
    // int[][] efforts = new int[rows][cols]
    // for int[] row : efforts
    // Arrays.fill(row, Integer.MAX_VALUE)
    // Priorityqueue<int[]> queue = new PriorityQueue<>((a,b)-> a[0] - b[0])
    // queue.offer(new int[]{0,0,0})
    // int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}}
    // while !queue.isEmpty()
    // int[] current= queue.poll()
    // int dist = current[0]
    // row = current[1]
    // col = current[2]
    // if row == rows-1 && col == cols-1
    // return dist
    // for int[] dir : dirs
    // newRow = row + dir[0]
    // newCol = col + dir[1]
    // newRow>=0 && newRow<rows && newCol>=0 && newCol<cols
    // abs = Math.abs(heights[row][col] - heights[newRow][newCol])
    // max = Math.max(dist, abs)
    // if max < effort[newRow][newCol]
    // effort[newRow][newCol] = max
    // queue.offer(new int[]{max, newRow, newCol}}
    // return 0
    private static int pathwithminimumEffort(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[][] effort = new int[rows][cols];

        for(int[] row: effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[0] -b[0]);
        queue.offer(new int[]{0,0,0});

        effort[0][0] = 0;

        int[][] dirs = {{-1,0},{1,0}, {0,-1}, {0,1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int currentMax = current[0];
            int row = current[1];
            int col = current[2];

            if(row == rows-1 && col == cols-1) {
               return currentMax;
            }

            for(int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow >=0 && newRow<rows && newCol>=0 && newCol<cols) {
                    int abs = Math.abs(heights[row][col] - heights[newRow][newCol]);

                   int  edgeLength = Math.max(currentMax, abs);

                   if(edgeLength < effort[newRow][newCol]) {
                       effort[newRow][newCol] = edgeLength;
                       queue.offer(new int[]{edgeLength, newRow, newCol});
                   }

                }
            }
        }
        return 0;
    }
    //brute
    // Try Every possible path
    // Use
    // dfs + backtracking
    // Keep track of
    // current Maximum effort
    // Destiantion reached
    // update minimum answer
    // dfs(0,0)
    // |
    // Maximum
    // |
    // Move four directions
    // |
    // destination reached
    // |
    // update minimum
    // |
    // backtrack
    // |
    // return minimum
    // why dfs
    // only one path can be used
    // in another path
    // visited[row][col] = false
    // T.C; O(4^(rows * cols))
    // S.c : o(rows*cols)
    // rows = heights.length
    // cols = heights[0].length
    // boolean[][] visited = new boolean[rows][cols]
    // int[] min = {Integer.MAX_VALUE}
    // dfs(heights,0,0,0,visited,min)
    // return min[0]
    // dfs
    // rows = heights.length
    // cols = heights[0].length
    // if(row<0 || row>=rows || col<0 || col>=cols || visited[row][col])
    // return
    // if row == rows-1 && col == cols-1
    // min[0] = Math.min(min[0], dist)
    // return
    // int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}}
    // visited[row][col] = true
    // for int[] dir : dirs
    // newRow = row + dir[0]
    // newCol = col + dir[1]
    // newRow>=0 && newRow<rows && newCol>=0 && newCol<cols && !visited[newRow][newCol]]
    // abs = Math.abs(heights[row][col] - heights[newRow][newCol])
    // max = Math.max(dist, abs)
    // dfs(heights, newRow, newCol, max, visited, min)
    // visited[row][col] = false
//    private static int pathwithminimumEffort(int[][] heights) {
//        int n = heights.length;
//
//        boolean[][] visited = new boolean[n][n];
//        int[] currentMaxEffort = {Integer.MAX_VALUE};
//
//        dfs(heights, 0,0, 0, currentMaxEffort, visited);
//
//        return currentMaxEffort[0] == Integer.MAX_VALUE ? -1 : currentMaxEffort[0];
//    }
//
//    private static void dfs(int[][] heights, int row, int col, int path, int[] currentMax, boolean[][] visited) {
//        int rows = heights.length;
//        int cols = heights[0].length;
//
//        if(row<0 || row>=rows || col<0 || col>=cols || visited[row][col]) {
//            return;
//        }
//
//
//        if(row == rows - 1 && col == cols-1) {
//            currentMax[0] = Math.min(currentMax[0], path);
//            return;
//        }
//
//        visited[row][col] = true;
//        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
//
//        for(int[] dir: dirs) {
//            int newRow = row + dir[0];
//            int newCol = col + dir[1];
//
//            if(newRow>=0 && newRow<rows && newCol>=0 && newCol<cols && !visited[newRow][newCol]) {
//                int abDiff = Math.abs(heights[row][col] - heights[newRow][newCol]);
//                int currentMaxs = Math.max(path, abDiff);
//
//                dfs(heights, newRow, newCol, currentMaxs, currentMax, visited);
//            }
//        }
//
//        visited[row][col] = false;
//    }
}
