package DSASheet.RecursionAndBackTracking;

public class WordSearch {
    public static void main(String[] args){
        char[][] board= {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word  = "ABCB";
        boolean searc = wordSearch(board, word);
        System.out.println(searc);
    }
    private static boolean wordSearch(char[][] board, String word) {
        //brute
        // generate all possible path from every cell
        // when path length equals word length
        // then return path compares word
        // loop through entire board
        // for row from 0 to board.length :
        // for col from 0 to board[0].length :
        // if(dfs(board, word, row, col, "")) :
        // true
        // return false
        // dfs(board, word, row, col, path) :
        // condition check
        // if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] == '#') :
        // return false
        // outbound or visited
        // add with current character
        // path = path  + board[row][col]
        // compares path.length == word.length
        // if(path.length() == word.length()) :
        // return path.eqauls(word)
        // char temp = board[row][col]
        // check for four directions
        //  found = dfs(board, word, row + 1, col, path) ||
        // dfs(board, word, row -1, col, path) ||
        // dfs(board, word, row, col-1, path) ||
        // dfs(board, word, row, col + 1, path)
        // backtrack
        // board[row][col] = '#'
        // restore original value
        // return found
        // T.C : o(m * n * 4^L * L)
        // S.C : o(L)
        int rows = board.length;
        int cols = board[0].length;

        for(int row=0; row<rows; row++) {
            for(int col=0; col<cols; col++) {
                if(dfs(board,word, row, col, "")) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, String word, int row, int col, String path) {
        if(row < 0 || col <0 || row>= board.length || col >= board[0].length || board[row][col] == '#') {
            return false;
        }

        path = path + board[row][col];

        if(path.length() == word.length()) {
            return path.equals(word);
        }

        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = dfs(board, word, row + 1, col, path) ||
                        dfs(board, word, row - 1, col, path) ||
                        dfs(board, word, row , col -1, path) ||
                        dfs(board, word, row , col + 1, path);

        board[row][col] = temp;

        return found;
    }
//    private static boolean wordSearch(char[][] board, String word) {
//       //optimized
        // geneate all character and compare later instead of comnparing character while moving if mismatch stop recursion immediately
       // this i called pruning
    //  loop through board
    // for row from 0 to board.length :
    // for col from  0 to board[0].length :
    // if(dfs(board, word, row, col , 0):
    // return true
    // return false
    // dfs(board, word, row, col , index) :
    // success check
    // if(index == word.length()) :
    // return true
    // condtion check
    // if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index)) :
    // return false
    // board[row][col] != word.charAt(index) pruning it is main optimization line
    // temp =  board[row][col]
    //  board[row][col] = '#'  visitied
    // found = dfs(board, word, row + 1, col, index + 1) ||
    //        dfs(board, word, row -1, col, index + 1) ||
    //        dfs(board, word, row, col-1, index + 1) ||
    //         dfs(board, word, row, col + 1, index + 1)
    // restore original value
    // board[row][col] = temp
    // return found
    // T.C : o(m * n * 3^L) or o(m * n * 3^L)
    // S.C : o(L)

//        int row = board.length;
//       int col = board[0].length;
//
//       for(int rows=0; rows<row; rows++) {
//           for(int cols=0; cols<col; cols++) {
//               if(dfs(board, word, rows , cols, 0)) {
//                   return true;
//               }
//           }
//       }
//
//       return false;
//    }
//    private static boolean dfs(char[][] board, String word, int row, int col, int index) {
//        if(index == word.length()) {
//            return true;
//        }
//
//        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index)) {
//            return false;
//        }
//
//        char temp = board[row][col];
//        board[row][col] = '#';
//
//        boolean found = dfs(board, word, row + 1, col, index + 1) ||
//                       dfs(board, word, row - 1, col, index + 1) ||
//                       dfs(board, word, row, col + 1, index + 1) ||
//                dfs(board, word, row, col - 1, index + 1);
//
//        board[row][col] = temp;
//
//        return found;
//    }
}
