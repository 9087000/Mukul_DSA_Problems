package DSASheet.Heap;

import java.util.PriorityQueue;

public class ReorganizeString {
    public static void main(String[] args) {
        String s = "aab";
        String reorganize = reorganizeString(s);
        System.out.println(reorganize);
    }

    private static String reorganizeString(String s) {
        //Optimized
        //Count the frequencies
        //put it into maxHeap
        //set prev == null
        // when maxHeap is not empty
        // pick max freq char
        // append to result
        // decrease freq
        // if prev has freq -> push back to heap
        // set curr = prev
        //T.c : o(n log 26) : o(n)
        //S.c: o(26)`
        int[] freq = new int[26];

        for(char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1] - a[1]);

        for(int i=0; i<26; i++) {
            if(freq[i] > 0) {
                maxHeap.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();

        int[] prev = null;

        while(!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();

            result.append((char) (curr[0] + 'a'));
            curr[1]--;

            if(prev != null && prev[1] > 0) {
                maxHeap.offer(prev);
            }

            prev = curr;
        }

        if(result.length() != s.length()) {
            return "";
        }

        return result.toString();
    }
}
