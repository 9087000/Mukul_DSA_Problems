package DSASheet.Grpahs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1}, {1,1,0}, {0,1,1}};
        int rotten = rottenOranges(grid);
        System.out.println(rotten);
    }
    //optimized
    // Use multiSource Bfs
    // Put all rotten oranges into queue first
    // Create a queue first
    // Count fresh oranges
    // Add all rotten oranges to queue
    // while queue is not empty and fresh > 0 :
    // Take size of queue
    // The size of queue represent all rotten oranges at current minute
    // process exactly that many oranges
    // For exactly each ortten:
    // Explore four directions
    // if neighbour orange is fresh:
    // mark it rotten
    // fresh --
    // add neighbour to queue
    // After procession one level
    // minutes++
    // if fresh == 0
    // return minutes
    // else
    // return -1
    // T.C : o(m*n)
    // S.C: o(m*n)
    // int fresh = 0;
    // int minutes = 0;
    // Queue<int[]> queue = new LinkedList<>()
    // for row from 0 to grid.length :
    // for col from 0 to grid[0].length :
    // if grid[row][col] == 2
    // queue.offer(new int[]{row,col});
    // if grid[row][col] == 1
    // fresh++
    // int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}}
    // while !queue.isEmpty() && fresh > 0 :
    // size = queue.size()
    // for i from 0 to size:
    // int[] current = queue.poll()
    // row = current[0]
    // col = current[1]
    // for int[] dir: dirs:
    // newRow = row + dir[0]
    // newCol = col + dir[1]
    // if newRow>=0 && newCol>=0 && newRow<grid.length && newCol<grid[0].length && grid[newRow][newCol] == 1:
    // grid[newRow][newCol] = 2;
    // fresh--
    // queue.offer(new int[]{newRow, newCol});
    // minutes++
    // return fresh == 0 ? minutes : -1
    private static int rottenOranges(int[][] grid) {
        int minutes = 0;
        int fresh = 0;

        Queue<int[]> queue = new LinkedList<>();

        for(int row=0; row<grid.length; row++) {
            for(int col=0; col<grid[0].length; col++) {
                if(grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                }

                if(grid[row][col] == 1) {
                    fresh++;
                }
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty() && fresh> 0) {
            int size = queue.size();

            for(int i=0; i<size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                for(int[] dir: dirs) {
                    int sr = row + dir[0];
                    int sc = col + dir[1];

                    if(sr>=0 && sc>=0 && sr<grid.length && sc<grid[0].length && grid[sr][sc] == 1) {
                        grid[sr][sc] = 2;
                        fresh--;
                        queue.offer(new int[]{sr,sc});
                    }
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
    //brute
    // Sitimulate minute by minute scanning of grid again and again
    // Count fresh oranges
    // while fresh > 0
    // set isChanged = false
    // scan the whole grid
    // if the fresh orange has rotten neighbour :
    // mark it as 3
    // why 3?
    // Because oranges are rotten after this minute
    // Convert all the 3 - > 2 after scanning
    // After every conversion :
    // fresh--
    // if no orange changed
    // means return -1
    // minutes++
    // return minutes
    // why not convert 1->2
    // because newly rotten orange should not rot other orange every minute
    // T.C:o((m*n)^2)
    // S.C ; o(1)
    // fresh = 0
    // minutes = 0
    // for row from 0 to grid.length :
    // for col from 0 to grid[0].length:
    // if grid[row][col] == 1:
    // fresh++
    // while fresh > 0:
    // isChanged = false
    // for row from 0 to grid.length:
    // for col from 0 to grid[0].length:
    // if grid[row][col] == 1 && hasRotten(grid,row,col) :
    // grid[row][col] = 3
    // if(!isChanged):
    // return -1
    // for row from 0 to grid.length:
    // for col from 0 to grid[0].length:
    // if grid[row][col] == 3:
    // grid[row][col] == 2
    // fresh--
    // minutes++
    // return minutes
    // hasRotten(int[][] grid, int row, int col) :
    // int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    // for int[] dir : dirs
    // int newRow = row + dir[0]
    // int newCol = col + dir[1]
    // if (newRow>=0 && newCol>=0 && newRow<grid.length && newCol<grid[0].length && grid[newRow][newCol] == 2)
    // return true
    // return false
//    private static int rottenOranges(int[][] grid) {
//        int minutes = 0;
//        int fresh = 0;
//
//        for(int row=0; row<grid.length; row++) {
//            for(int col=0; col<grid[0].length; col++) {
//                if(grid[row][col] == 1) {
//                    fresh++;
//                }
//            }
//        }
//
//        while (fresh > 0) {
//            boolean isChanged = false;
//            for(int row=0;row<grid.length; row++) {
//                for(int col=0; col<grid[0].length; col++) {
//                    if(grid[row][col] == 1 && hasRotten(row, col, grid)) {
//                        grid[row][col] = 3;
//                        isChanged = true;
//                    }
//                }
//            }
//
//            if(!isChanged) {
//                return -1;
//            }
//
//            for(int row=0;row<grid.length; row++) {
//                for(int col=0; col<grid[0].length; col++) {
//                    if(grid[row][col] == 3) {
//                        grid[row][col] = 2;
//                        fresh--;
//                    }
//                }
//            }
//            minutes++;
//        }
//
//        return minutes;
//    }
//    private static boolean hasRotten(int row, int col, int[][] grid) {
//        int[][] dirs = {{1,0}, {-1,0}, {0,1} , {0,-1}};
//
//        for(int[] dir : dirs) {
//            int sr = row + dir[0];
//            int sc = col + dir[1];
//
//            if(sr>=0 && sc>=0 && sr<grid.length && sc<grid[0].length && grid[sr][sc] == 2) {
//                return true;
//            }
//        }
//        return false;
//    }
}
