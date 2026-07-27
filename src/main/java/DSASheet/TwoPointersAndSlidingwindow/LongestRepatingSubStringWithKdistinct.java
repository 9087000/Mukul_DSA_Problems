package DSASheet.TwoPointersAndSlidingwindow;

import java.util.HashMap;
import java.util.Map;
//We are using slinding window approach for this intialize two pointers left and right with best for updating answer
//We need to track index of each character Map<Character, Integer>
//add the frequency of character to the map
//if window is invalid freq.size() > k
   // decrement the freq of character in left
   // if it is 0 remove
   // increment left
//update answer
public class LongestRepatingSubStringWithKdistinct {
    public static void main(String args[]) {
        String s = "aabb";
        int k = 3;
        int longest = longestRepeatingSubString(s, k);
        System.out.println(longest);
    }

    private static int longestRepeatingSubString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int best = 0;

        for(int right=0; right<s.length(); right++) {
            Character c= s.charAt(right);

            map.put(c, map.getOrDefault(c, 0) + 1);

            if(map.size()>=k) {
                Character leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if(map.get(leftChar) == 0) map.remove(leftChar);
                left++;
            }
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
}
