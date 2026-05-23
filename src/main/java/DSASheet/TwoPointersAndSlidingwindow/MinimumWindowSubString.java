package DSASheet.TwoPointersAndSlidingwindow;

import java.util.HashMap;
import java.util.Map;

//Build the mapT Map<Character, Integer> mapT = new HashMap<>() and track the each character of string in t and add it ot mapt
//Intiliaze sliding window variables Map<Character, Integer> windowMap = new HashMap<>(); int required= mapT.size(); int formed = 0; int left = 0; int minLen = Integer.MAX_VALUE; int start = 0;
//Expand right
//if character in t will match the required count , then formed++
//If the window is valid required == formed && left<=right
// update answer
//if chacter is in t and we need below count then window becamome invalid and formed--
public class MinimumWindowSubString {
    public static void main(String args[]) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String l = minimumWindow(s, t);
        System.out.println(l);
    }
    private static String minimumWindow(String s, String t) {
        if(s == null || t == null || t.length() == 0|| s.length() < t.length()) return  "";

       Map<Character, Integer> mapT = new HashMap<>();
       for(int i=0; i<t.length(); i++) {
           Character ch = t.charAt(i);
           mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
       }

       Map<Character, Integer> windowMap = new HashMap<>();
       int required = mapT.size();
       int formed = 0;

       int left = 0;
       int minLen = Integer.MAX_VALUE;
       int start = 0;

       for(int right = 0; right<s.length(); right++) {
           Character ch = s.charAt(right);

           windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);

           if(mapT.containsKey(ch) && windowMap.get(ch).intValue() == mapT.get(ch).intValue()) {
               formed++;
           }

           while(formed == required && left<=right) {
               int windowLen = right - left + 1;
               if (windowLen < minLen) {
                   minLen = windowLen;
                   start = left;
               }

               Character leftChar = s.charAt(left);
               windowMap.put(leftChar, windowMap.get(leftChar) - 1);
               if (mapT.containsKey(leftChar) && windowMap.get(leftChar) < mapT.get(leftChar)) {
                   formed--;
               }

               left++;
           }
       }
       return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
