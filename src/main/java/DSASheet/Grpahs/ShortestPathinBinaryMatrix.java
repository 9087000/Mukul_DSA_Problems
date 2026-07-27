package DSASheet.Grpahs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = {{0,1},{1,0}};
        int shortestPath = shortestPathinbinary(grid);
        System.out.println(shortestPath);
    }

    //optimized
    // Every move has
    // Equal cost = 1
    // Use
    // Bfs
    // bfs explores
    // level by level
    // First time destination reached
    // shortest path found
    // source
    // |
    // distance 1
    // |
    // distance 2
    // |
    //  distance 3
    // All distance 1
    // |
    // All distance 2
    // |
    // All distance 3
    // first destination reached
    // |
    // shortest path found
    // check start & end
    // |
    // intilaize queue
    // |
    //  Insert(0,0,1)
    // |
    //  mark visited
    // |
    // poll current queue
    // |
    // destination reached?
    // |
    //  return dist
    // |
    // All 8 directions
    // |
    // valid
    // |
    //  push into queue
    // |
    //  return -1
    // BFS
    // queue
    // follows FIFO
    // Earlier inserted cells
    // |
    // processed first
    // |
    // Maintain level order traversal
    // |
    // Gurantees shortest path
    // T.C : o(N2)
    // S.C: o(N2)
    // n = grid.length
    // if(grid[0][0] == 1 || grid[n-1][n-1] == 1
    // return -1
    // int[][] dirs = {{-1,-1}, {-1,0}, {-1,1}, {0,-1} ,{0,1}, {1,-1}, {1,0}, {1,1}}
    // Queue<int[]> queue = new LinkedList<>()
    // queue.offer(new int[]{0,0,1})
    // grid[0][0] = 1
    // while !queue.isEmpty()
    // int[] current = queue.poll()
    // row = current[0]
    // col = current[1]
    // dist = current[2]
    // if row == n-1 && col == n-1
    // return dist
    // for(int[] dir: dirs)
    // newRow = row + dir[0]
    // newCol = col + dir[1]
    // if newRow>=0 && newRow<n && newCol>=0 && newCol<n && grid[newRow][newCol] == 0
    // grid[newRow][newCol] = 1
    // queue.offer(new int[]{newRow,newCol, dist+1})
    // return -1

    private static int shortestPathinbinary(int[][] grid) {
        int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }

        int[][] dirs = {{-1,-1}, {-1,0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,1}, {1,0}};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,1});

        grid[0][0] = 1;

        while (!queue.isEmpty()){
            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            int dist = current[2];

            if(row == n-1 && col == n-1) {
                return dist;
            }

            for(int[] dir: dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if(newRow >= 0 && newRow<n && newCol>=0 && newCol<n && grid[newRow][newCol] == 0) {
                    grid[newRow][newCol] = 1;
                    queue.offer(new int[]{newRow, newCol, dist + 1});
                }
            }

        }

        return -1;
    }

    //brute
    // Try every possible path using
    // dfs + backtrack
    // Keep track of
    // current distance
    // whenever destination reached
    // update min value
    // check start & end
    // |
    //  create visited[][]
    // |
    // Try all 8 directions
    // |
    // destination reached
    // |
    // update minimum
    // |
    //  backtrack
    // |
    // return minimum
    // T.C : o(8^(N2)
    // S.C : o(N2)
    // n = grid.length
    // if grid[0][0] == 1 || grid[n-1][n-1] == 1
    // return -1
    // boolean[][] visited = new boolean[n][n]
    // int[] min = {Integer.MAX_VALUE}
    // dfs(grid, 0,0, 1, visited, min)
    // return min[0] = Integer>MAX_VALUE ? -1 : min[0]
    // dfs
    // n = grid.length
    // if(row <0 || row>=n || col<0 || col>=n || grid[row][col] == 0 || visited[row][col])
    // return
    // if(row == n-1 && col==n-1)
    // min[0]= Math.min(min[0] , dist)
    // return
    // visited[row][col] = true
    // int[][] dirs = {{-1,-1}, {-1,0}, {-1,1} , {0,-1} , {0,1} , {1,-1} , {1,0}, {1,1}}
    // for int[] dir : dirs
    // dfs(grid, row + dir[0] , col + dir[1] , dist + 1, visited, min)
    // visited[row][col] = false
//    private static int shortestPathinbinary(int[][] grid) {
//        int n = grid.length;
//
//        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) {
//            return -1;
//        }
//
//        int[] min = {Integer.MAX_VALUE};
//
//        boolean[][] visited = new boolean[n][n];
//
//       dfs(grid, 0, 0, 1, visited, min);
//
//
//        return min[0] == Integer.MAX_VALUE ? -1 : min[0];
//    }
//
//    private static void dfs(int[][] grid, int row, int col, int distance, boolean[][] visited, int[] min) {
//        int n = grid.length;
//
//        if(row<0 || row>=n || col<0 || col>=n || grid[row][col] == 1 || visited[row][col]) {
//             return;
//        }
//
//        if(row==n-1 && col == n-1) {
//            min[0] = Math.min(min[0], distance);
//            return;
//        }
//
//        visited[row][col] = true;
//
//        int[][] dirs = {{-1,-1}, {-1, 0}, {-1,1}, {0,-1}, {0,1}, {1,-1}, {1,0}, {1,1}};
//
//        for(int[] dir : dirs) {
//            dfs(grid, row + dir[0] , col+ dir[1], distance + 1, visited, min);
//        }
//
//        visited[row][col] = false;
//    }
}
