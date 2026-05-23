package DSASheet.TwoPointersAndSlidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//idea : Anagram means same frequency same character  k > s.length fixed window size
// Sliding  window with two pointers
// Step 1 : if(k > s.length()) return empty list
//step 2: builds
// need[26] from character p
// win[26] from firstk chars of s
//if Arrays.equals(need, win) add 0 to the list
//slid window (r to k-1)
//Add / increment the right s[r]++
//remove the leftChar s[r-k]--
//if arrays.equals(need, win) add r-k+ to the list
//return list
public class FindAllAnagramsinString {
    public static void main(String[] args) {
        String s1 = "cbaebabacd";
        String s2 = "abc";
        List<Integer> anagrams = anagrams(s1,s2);
        System.out.println(anagrams);
    }

    private static List<Integer> anagrams(String s1, String s2) {
        int k = s2.length();
        List<Integer> list = new ArrayList<>();
        if(k > s1.length()) return  list;
        int[] need = new int[26];
        int[] win = new int[26];

        for(int i=0; i<k; i++) {
            need[s2.charAt(i) - 'a']++;
            win[s1.charAt(i) - 'a']++;
        }

        if(Arrays.equals(need, win)) list.add(0);

        for(int r=k; r<s1.length(); r++) {
            win[s1.charAt(r) - 'a']++;
            win[s1.charAt(r -k) - 'a']--;

            if(Arrays.equals(need, win)) list.add(r-k+1);
        }

        return list;
    }
}
