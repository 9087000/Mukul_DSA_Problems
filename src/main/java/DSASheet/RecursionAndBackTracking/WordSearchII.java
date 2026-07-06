package DSASheet.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearchII {
    public static void main(String args[]) {
        char[][] board = {{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};
        List<String> word = List.of(new String[]{"oath", "pea", "eat", "rain"});
        List<String> words= wordSearchII(board, word);
        System.out.println(words);
    }
    //brute
    // For every word in word[]
    // run the word search 1 seperately
    // result = []
    // for every word in word
    // check if exists of board  , word :
    // result.add(word)
    // result
    // exists(board, word) :
    // rows = board.length
    // cols = board[0].length
    // for row from 0 to rows :
    // for cols from 0 to cols:
    // if dfs(board, word, row, col, 0) :
    // true
    // false
    // dfs(board, word, row, col, index) :
    // if index == word.length())
    // return true
    // if row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index))
    // return false
    // char temp = board[row][col]
    // board[row][col] = '#'
    // boolean = dfs(board, word, row + 1, col , index + 1) ||
    //           dfs(board, word, row - 1, col , index + 1) ||
    //           dfs(board, word, row , col - 1 , index + 1) ||
    //           dfs(board, word, row, col + 1, index + 1);
    // board[row][col] = temp
    // return found
    // T.C : o(W * M * n * 3^L)
    // S.C : o(L)
//    private static List<String> wordSearchII(char[][] board, List<String> word) {
//        List<String> result = new ArrayList<>();
//
//        for(String words : word) {
//            if(exist(board, words)) {
//                result.add(words);
//            }
//        }
//
//        return result;
//    }
//
//    private static boolean exist(char[][] board, String word) {
//        int rows = board.length;
//        int cols = board[0].length;
//
//        for(int row=0; row<rows; row++) {
//            for(int col=0; col<cols; col++) {
//                if(dfs(board, word, row, col, 0)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//    private static boolean dfs(char[][] board, String word, int row, int col, int index) {
//
//        if(index == word.length()) {
//            return true;
//        }
//
//        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index) ) {
//            return false;
//        }
//
//        char temp = board[row][col];
//        board[row][col] = '#';
//
//        boolean found = dfs(board, word, row + 1, col, index + 1) ||
//                        dfs(board, word, row - 1, col, index + 1) ||
//                        dfs(board, word, row, col -1, index + 1) ||
//                        dfs(board, word, row, col + 1, index + 1);
//
//        board[row][col] = temp;
//
//        return found;
//    }
    //optimized
    // Insert all words into trie
    // Run the DFS once for every board cells
    // Trie is used to stop the index/wors that are not prefixs
    // Build all words using trie
    // Run the Dfs for every board cell
    // After every cell:
    // check current character exist in Trie child
    // if child does not exist:
    // stop
    // if it exist
    // move to trie child
    // if trie.word != null :
    // word is found add to result
    // Mark as visited
    // explore 4 directions
    // Restore cell
    // result = []
    // TrieNode node = new TrieNode
    // for word in words
    // insert(node, word)
    // for row from 0 to board.length:
    // for col from 0 to board[0].length:
    // dfs(board, row, col, node, result)
    // return result
    // insert(node, word) :
    // TrieNode root = node
    // for char c : word.toCharArray() :
    // index = c - 'a'
    // if root.children[index] == null
    // root.children[index] = new TrieNode()
    // root = root.children[index]
    // root.word = word
    // dfs(board, row, col, node, result) :
    // if(row <0 || col < 0 || row>=board.length || col>=board[0].length || board[row][col] == '#') :
    // return;
    // char ch = board[row][col]
    // int index = ch - 'a';
    // if(node.children[index] == null) :
    // return
    // node = node.children[index]
    // if(node.word != null):
    // result.add(node.word)
    // node.word = null
    // board[row][col] = '#'
    // dfs(board, row +1 , col, node, result);
    // dfs(board, row - 1, col, node, result);
    // dfs(board, row, col - 1, node, result);
    // dfs(board, row, col + 1, node, result);
    // board[row][col] = ch
    public static List<String> wordSearchII(char[][] board, List<String> word) {
        List<String> result = new ArrayList<>();

        Trienode root = new Trienode();

        for(String words: word) {
            insert(root, words);
        }

        for(int row=0; row<board.length; row++) {
            for(int col=0; col<board[0].length; col++) {
                dfs(board,  row, col, root, result);
            }
        }

        return result;
    }

    private static void insert(Trienode root, String word) {
        Trienode node = root;

        for(char ch : word.toCharArray()) {
            int index = ch - 'a';

            if(node.children[index] == null) {
                node.children[index] = new Trienode();
            }
            node = node.children[index];
        }
        node.word = word;
    }
    private static void dfs(char[][] board, int row, int col, Trienode root, List<String> result) {
        if(row<0 || col < 0|| row >= board.length || col >= board[0].length || board[row][col] == '#') {
            return;
        }

        char ch = board[row][col];
        int index = ch - 'a';

        if(root.children[index] == null) {
            return;
        }

        root = root.children[index];

        if(root.word != null) {
            result.add(root.word);
            root.word = null;
        }

        board[row][col] = '#';

        dfs(board,  row + 1, col, root, result);
                        dfs(board, row - 1, col,  root, result);
                        dfs(board, row, col -1, root, result);
                        dfs(board, row, col + 1, root, result);

        board[row][col] = ch;

    }
}
