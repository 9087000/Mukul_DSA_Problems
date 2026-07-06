package DSASheet.Grpahs;

import java.util.Arrays;

public class FloodFill {
    public static void main(String[] args) {
        int[][] image = {{1,1,1}, {1,1,0}, {1,0,1}};
        int sr = 1;
        int sc = 1;
        int color = 2;
        int[][] flood = flodFill(image, sr, sc, color);
        for(int row=0; row<flood.length; row++) {
            for(int col=0; col<flood[0].length; col++) {
                System.out.print(flood[row][col] + " ");
            }
        }
        System.out.println();
    }
    //optimized
    //No visited
    // once we change
    // image[sr][sc] = color
    // cell will not match originalColor again
    // store originalColor
    // if originalColor == color
    // return image
    // start dfs from sr and sc
    // if out of bound
    // return
    // if image[sr][sc] != originalColor
    // return
    // image[sr][sc] = color
    // explore all four direction
    // return image
    // T.C : o(m * n)
    // S.C : o(1)
    private static int[][] flodFill(int[][] image, int sr, int sc, int color) {
       int originalColor = image[sr][sc];
       int newColor = color;

       dfs(image, sr, sc, originalColor, newColor);

       if(originalColor == newColor) {
           return image;
       }

       return image;
    }

    private static void dfs(int[][] image, int sr, int sc, int originalColor, int newColor) {
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc] != originalColor)  {
            return;
        }

        image[sr][sc] = newColor;

        dfs(image, sr + 1, sc, originalColor, newColor);
        dfs(image, sr - 1, sc, originalColor, newColor);
        dfs(image, sr, sc + 1, originalColor, newColor);
        dfs(image, sr, sc - 1, originalColor, newColor);
    }
}
    //brute
    // use Visited[][]
    // Originalcolor = image[sr][sc]
    // newColor = color
    // change only the connected cells having original color
    // store original color
    // newColor = color
    // create boolean array of size image.length and image[0].length
    // if originalcolor == newColor
    // return image
    // start dfs from sr and sc
    // if the cell is invalid
    // return
    // if visited already
    // return
    // if image[sr][sc] != originalColor
    // return
    // visited[row][col] = true
    // image[sr][sc] = newColor
    // explore 4 directions
    // return image
    // T.C : o(m * n)
    // S.C : o(m * n)
//    private static int[][] flodFill(int[][] image, int sr, int sc, int color) {
//        int originalColor = image[sr][sc];
//        int newColor = color;
//
//        boolean[][] visited = new boolean[image.length][image[0].length];
//
//        dfs(image, sr, sc, newColor, originalColor, visited);
//
//        if(originalColor == newColor) {
//            return image;
//        }
//
//        return image;
//    }
//
//    private static void dfs(int[][] image, int sr, int sc, int newColor, int originalColor, boolean[][] visited) {
//        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || visited[sr][sc] || image[sr][sc] != originalColor) {
//            return;
//        }
//
//        visited[sr][sc] = true;
//
//        image[sr][sc] = newColor;
//
//        dfs(image, sr + 1, sc, newColor, originalColor, visited);
//        dfs(image, sr - 1, sc, newColor, originalColor, visited);
//        dfs(image, sr, sc + 1, newColor, originalColor, visited);
//        dfs(image, sr, sc - 1, newColor, originalColor, visited);
//    }
//}
