package DSASheet.TwoPointersAndSlidingwindow;

import java.util.Arrays;
import java.util.Scanner;
//1.prepare memory to remember last session
// create an array lastIndex[256] (for all ASCII chars) and set every value to -1
//2.Intialize window and answer
//.left =0 (start of current index)
//.maxLen = 0 (best answer so far)
//3.scan the string with  a right pointer
//.for right  0  to n -1
//let ch = s [right]
//if lastIndex[ch] >= left , it means ch occurred inside the current window
//. Move left to another previous occurrence
//.left = lastIndex[ch] + 1
//.update lastIndex[ch] = right (record this last position)
//. Compute the current window length len = right - left + ;
//.Update Answer : mxLen = max(maxLen, len)
//4 . Return maxLen

public class LongestSubstring {
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      sc.nextLine();
      while(t --> 0) {
          String s = sc.nextLine().trim();
          int longest = longestSubString(s);
          System.out.println(longest);
      }
    }
    public static int longestSubString(String s) {
        int n = s.length();
        int[] last = new int[256];
        Arrays.fill(last, -1);
        int left = 0, maxLen = 0;
        for(int right=0; right<n; right++) {
            char c = s.charAt(right);

            if(last[c] >= left) {
                left = last[c] + 1;
            }
            last[c] = right;
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
