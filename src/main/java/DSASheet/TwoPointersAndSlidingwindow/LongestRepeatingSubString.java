package DSASheet.TwoPointersAndSlidingwindow;

import java.util.HashMap;
import java.util.Map;

//Intialize two pointers left and right and window maintaining bedt
//We need structure  to track index of each character
//When we see repeated character move the left  to max(left, c.get(ch) + 1)
//update the c
//update answer
public class LongestRepeatingSubString {
    public static void main(String args[]) {
        String s = "pwwkew";
        int Longest = longestRepeatingSubString(s);
        System.out.println(Longest);
    }

    private static int longestRepeatingSubString(String s) {
        Map<Character, Integer> c = new HashMap<>();
        int left = 0;
        int bedt = 0;

        for(int right = 0;right< s.length(); right++) {
            Character k = s.charAt(right);

            if(c.containsKey(k)) {
                left = Math.max(left, c.get(k) + 1);
            }
            c.put(k, right);
            bedt = Math.max(bedt , right - left + 1);
        }
        return bedt;
    }
}
