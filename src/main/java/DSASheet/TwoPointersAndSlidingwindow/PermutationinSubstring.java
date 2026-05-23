package DSASheet.TwoPointersAndSlidingwindow;

import java.util.Arrays;
//Fixed-window Size using slidingwindow
//idea:
//string s1 is of length k
// check every character s2 is substring of length k
//Permutation means
//Same character
//same Frequency
//does not maintain any order
//steps:
//if k > s2.length() return false
//Builds
//need[26] builds from s1
//win[26] builds from first character of s2
//if(Arrays.equals(need, win)) return true;
//sliding window by one more time
//increment right pointer
//decrement leftChar
//if(Arrays.equals(need, win)) return true
//return false
public class PermutationinSubstring {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        Boolean s = permutationString(s1, s2);
        System.out.println(s);
    }

    private static boolean permutationString(String s1, String s2) {
        int k = s1.length();
        if(k > s2.length()) return false;

        int[] need = new int[26];
        int[] win = new int[26];

        for(int i=0; i<k ;i++) {
            need[s1.charAt(i) - 'a']++;
            win[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(need, win)) return true;
        for(int r=k; r<s2.length(); r++) {
            win[s2.charAt(r) - 'a']++;
            win[s2.charAt(r-k) - 'a']--;
            if(Arrays.equals(need, win)) return true;
        }
        return false;
    }
}
