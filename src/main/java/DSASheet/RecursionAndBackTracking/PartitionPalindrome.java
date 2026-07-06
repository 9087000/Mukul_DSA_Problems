package DSASheet.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;

public class PartitionPalindrome {
    public static void main(String args[]) {
        String s = "aab";
        List<List<String>> palindrome = partitionPalindrome(s);
        System.out.println(palindrome);
    }
    private static List<List<String>> partitionPalindrome(String s) {
        //brute
        // Generate all possible partitions
        // only at the ned check whether it is palindrome or not
        // result = []
        // current = []
        // solve(index, s, current, result)
        // return result
        // solve(index, s, current, result) :
        // if(index == s.length()) :
        // check whether current string are in palindrome
        // if( valid(current)) :
        // add the copy of current to result
        // return
        // for i from index to s.length() - 1 :
        // substring of index , i + 1
        // add sub to current
        // recurse (i+1, n, current, result)
        // backtrack
        // current.remove(curret.size() - 1)
        // valid(List<String> current):
        // for(String s : current) :
        // if(!isPlaindrome(s)) :
        // return false
        // return true
        // palindrome(string s) :
        // left = 0
        // right = s.length() - 1
        // while left < right :
        // if(s.charAt(left) != s.charAt(right)) :
        // return false
        // left++
        // right--
        // return true
        // T.C : o(2^n * n)
        // S.C : o(n)
//        List<List<String>> result = new ArrayList<>();
//        List<String> current = new ArrayList<>();
//        solve(0, s, current, result);
//        return result;
        //optimized
        // check palindrome before recursion itself
        // avoid invalid branches early
        // result = []
        // current = []
        // solve(0, s, current, result)
        // return result
        // solve(int index, String s, List<String> current, List<List<String>> result) :
        // if(index == s.length()) :
        // add the copy of current to result
        // return
        // result.add(new ArrayLisT<>(current))
        // return
        // for start from index to s.length() - 1 :
        //substring of index and i + 1
        // if (ispalindrome(s)):
        // current add sub
        // recurse solve(i + 1, n , current, result)
        // backtrack
        // current.remove(current.size() - 1)
        // isPalindrome(string s):
        // left = 0
        // right = s.length() - 1
        // while left < right :
        // if(s.charAT(left) != s.charAt(right)) :
        // return false
        // left++
        // right--
        // return true
        // T.C : o(2^n * n)
        // S.C : o(n)
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        solve(0, s, current, result);
        return result;
    }

    private static void solve(int index, String s, List<String> current, List<List<String>> result) {
        if(index == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=index; i<s.length(); i++) {
            String sub = s.substring(index, i+1);
            if(ispalindrome(sub)) {
                current.add(sub);
                solve(index + 1, s, current, result);
                current.remove(current.size() - 1);
            }
        }
    }

//    private static void solve(int index, String s, List<String> current, List<List<String>> result) {
//        if(index == s.length()) {
//            if(valid(current)) {
//                result.add(new ArrayList<>(current));
//                return;
//            }
//        }
//        for(int i=index; i<s.length(); i++) {
//            String sub = s.substring(index, i + 1);
//            current.add(sub);
//            solve(i +1 , s, current, result);
//            current.remove(current.size() - 1);
//        }
//    }
//    private static boolean valid(List<String> current) {
//        for(String s : current) {
//            if(!ispalindrome(s)) {
//                return false;
//            }
//        }
//        return true;
//    }

    private static boolean ispalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
