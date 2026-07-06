package DSASheet.RecursionAndBackTracking;

import java.util.ArrayList;

public class RatinMaze {
    public static void main(String[] args) {
        int[][] maze = {{1,0,0,0} , {1,1,0,1}, {1,1,0,0}, {0,1,1,1}};

        ArrayList<String> rat = ratinmaze(maze);

        System.out.println(rat);
    }
    //optimized
    //same logic instead of 4 recursive calls use direction arrays
    // dr[] = {1,0,0,-1}
    // dc[] = {0,-1,1,0}
    //dir = "DLRU"
    // start at (0,0)
    // check for invalid case
    // row <0 || col < 0 || row >=n || col >=n || maze[row][col] == 0 || visited[row][col]
    // return
    // row == n - 1 && col == n - 1
    // add the path to result
    // return
    //mark the cell as visited
    // dr[] = {1,0,0,-1}
    // dc[] = {0,-1,1,0}
    // dir = "DLRU"
    // for i from o to 4:
    // recurse
    // solve(maze, row + dr[i] , col + dc[i] , path + dir.charAt(i), result , visited)
    // backtrack
    // visited[row][col] = false
    // result = []
    // if(maze[0][0] == 0) return result
    // n = maze.length
    // boolean[][] visited = new boolean[n][n]
    // solve(maze, 0 , 0  "", result, visited)
    // return result
    // solve(maze, int row, int col, String path, ArrayList<String> result, boolean visited) :
    // n = maze.length
    // if(row < 0 || col < 0 || row>=n || col>=n || maze[row][col] == 0 || visited[row][col] )
    // return
    // row == n - 1 && col == n - 1
    // result.add(path)
    // return
    // visited[row][col] = true
    // dr[] = {1,0,0,-1}
    // dc[] = {0,-1,1,0}
    // dir = "DLRU"
    // for int i =0; i<4; i++ :
    // solve(maze, row + dr[i] , col + dc[i] , path + dir.charAt(i), result, visited)
    // backtrack
    // visited[row][col] = false
    // T.C : 4^(n*n)
    // S.C : (n * n)
    private static ArrayList<String> ratinmaze(int[][] maze) {
        ArrayList<String> result = new ArrayList<>();

        if(maze[0][0] == 0) return result;

        int n = maze.length;
        boolean[][] visited = new boolean[n][n];

        solve(maze, 0, 0, "", result, visited);

        return result;
    }

    private static void solve(int[][] maze, int row, int col, String path , ArrayList<String> result, boolean[][] visited) {
        int n = maze.length;

        if(row < 0 || col < 0 || row >= n || col >=n || maze[row][col] == 0 || visited[row][col]) {
            return;
        }

        if(row== n-1 && col== n-1) {
            result.add(path);
            return;
        }

        visited[row][col] = true;
        int[] dr = {1,0,0,-1};
        int[] dc = {0,-1,1,0};
        String dir = "DLRU";

        for(int i=0; i<4; i++) {
            solve(maze, row + dr[i], col + dc[i], path + dir.charAt(i), result, visited);
        }
        visited[row][col] = false;
    }
//    //brute
    //from current cell try all 4 direction : D, L , R, U
    // Start from 0,0
    // n = maze.length
    // Check invalid case :
    // row < 0 || col < 0 || row >= n || col >= n || maze[row][col] == 0 || visited[row][col]
    // return
    // row == n - 1 && col == n - 1
    // add the path to result
    // return
    // mark the cell as visited
    // row + 1 , path + "D"
    // col - 1 , path + "R"
    // col + 1 , path + "L"
    // row - 1, path + "U"
    // recurse above
    // backtrack
    // visited[row][col] = false
    // result = []
    // if(maze[0][0] == 0) return result;
    // n = maze.length
    // boolean[][] visited = new boolean[n][n]
    // solve(maze, 0, 0, "", result ,visited)
    // return result
    // solve(maze, row, col, path, result, visited) :
    // n = maze.length
    //if(row <0 || col <0 || row >= n || col >= n || maze[row][col] == 0 || visited[row][col]) :
    // return;
    // if(row == n - 1 && col == n - 1) :
    // result.add(path)
    // return
    // visited[row][col] = true
    // solve(maze, row + 1, col, path + "D" , result, visited)
    // solve(maze, row, col - 1, path + "R" , result, visited)
    // solve(maze, row, col + 1, path + "L" , result, visited)
    // solve(maze, row - 1. col, path + "U" , result, visited)
    // visited[row][col] = false
    // T.C: o(4^(n*n))
    // S.C : o(n*n)
//    private static ArrayList<String> ratinmaze(int[][] maze) {
//        ArrayList<String> result = new ArrayList<>();
//        if(maze[0][0] == 0) return  result;
//        int n = maze.length;
//        boolean[][] visited = new boolean[n][n];
//
//        solve(maze, 0, 0, "", result, visited);
//
//        return result;
//    }
//    private static void solve(int[][] maze, int row, int col, String path, ArrayList<String> result, boolean[][] visited) {
//        int n = maze.length;
//
//        if(row<0 || col< 0 || row >= n || col >= n || maze[row][col] == 0 || visited[row][col]) {
//            return;
//        }
//
//        if(row == n-1 && col == n-1) {
//            result.add(path);
//            return;
//        }
//
//        visited[row][col] = true;
//
//        solve(maze, row+1, col, path + "D" , result, visited);
//        solve(maze, row, col -1 , path + "L", result, visited);
//        solve(maze, row, col + 1, path + "R", result, visited);
//        solve(maze, row - 1, col, path + "U", result, visited);
//
//        visited[row][col] = false;
//    }
}
