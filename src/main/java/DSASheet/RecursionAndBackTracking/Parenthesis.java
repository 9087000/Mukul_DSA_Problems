package DSASheet.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {
    public static void main(String args[]) {
        int n = 3;
        List<String> parent = parenthesis(n);
        System.out.print(parent);
    }
    private static List<String> parenthesis(int n) {
        //brute
        // generate all possible string of length 2 * n
        // each has two choices
        // add '(' or
        // add ')'
        // all strings are generated
        // check whether it is valid or not
        // result = []
        // solve( "", n, result)
        // return result
        // solve(string s, int n, List<String> result):
        // if(s.length() == 2 * n) :
        // if(isValid(s)):
        // parent.add(s)
        // return
        // solve(s + "(", n, parent)
        // solve(s + ")", n, parent)
        // isValid(s):
        // balance = 0
        // for char c : s.toCharArray :
        // if(c == '(') balance++;
        // else balance--;
        // if(balance < 0) return false
        // return balance  == 0
        // T.C : o(2^(2n) * n)
        // S.C : o(n) // ignoring output
        // S.C : o(2^(2n) * n)
//        List<String> parent = new ArrayList<>();
        // opencount = 0;
        // closecount = 0
//        solve("", n, parent, opencount, closecount);
//        return parent;
        //optimized
        // generate all possible valid strings
        // open count means add '('
        // close count means add ')'
        // result = []
        // solve("", n, result)
        // return result
        // solve(string s , n , result, opencount, closecount) :
        // if(s.length() == 2 * n) :
        // result.add(s)
        // return
        // if(openCount < n) :
        // solve(s + "(" , n, result , opencount + 1, closecount)
        // if(closeCount < opencount) :
        // solve(s + "(" , n, result , opencount, closecount + 1)
        // T.C : o(4^n)/ (sqrt(n))
        // T.C : o(2^n)
        // s.C :o(n)
        List<String> parent = new ArrayList<>();
        int openCount = 0;
        int closeCount = 0;

        solve("", n , openCount, closeCount, parent);
        return parent;
    }
    private static void solve(String s, int n, int openCount, int closeCount , List<String> parent) {
        if(s.length() == 2 * n) {
            parent.add(s);
        }
        if(openCount < n) {
            solve(s + "(" , n, openCount + 1, closeCount, parent);
        }
        if(closeCount < openCount) {
            solve(s + ")" , n, openCount, closeCount + 1, parent);
        }
    }
//    private static void solve(String s, int n, List<String> parent) {
//        if(s.length() == 2 * n) {
//            if(isValid(s)) {
//                parent.add(s);
//            }
//            return;
//        }
//        solve(s + "(" , n, parent);
//        solve(s + ")" , n, parent);
//    }
//    private static boolean isValid(String s) {
//        int balance = 0;
//
//        for(char c : s.toCharArray()) {
//            if(c == '(') balance++;
//            else balance--;
//
//            if(balance < 0) return false;
//        }
//        return balance == 0;
//    }
}
