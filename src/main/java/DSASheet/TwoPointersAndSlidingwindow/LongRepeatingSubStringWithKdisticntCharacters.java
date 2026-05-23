package DSASheet.TwoPointersAndSlidingwindow;
//state intialize frequency of 26 characters
//int unique = 0 how many freq of chars greater > 0 in window
// int atleast = 0 how many freq of chars greater >= k
// intialize two pointer left and right
//Expand right
//update the freq
//if char count is 0 unique++
// if char count is k atLeastK++
//shrink window when unique > targetIndex
//updated/ decrement the freq left
//if the count is k-1 atLeastK--
//if count is 1 unique--
//l++
//Valid window if atleastK == t and uniqueIndex == t
//updated answer

public class LongRepeatingSubStringWithKdisticntCharacters {
    public static void main(String[] args) {
        String s = "aaabb";
        int k = 3;
        int repating = repatingSubsTring(s,k);
        System.out.println(repating);
    }

    private static int repatingSubsTring(String s, int k) {
        int n = s.length();
        int ans = 0;

        for(int targetIndex = 1; targetIndex <=26; targetIndex++) {
            int[] freq = new int[26];
            int l =0, r=0;
            int uniqueIndex = 0;
            int atLeastK = 0;

            while(r < n) {
                int idxR = s.charAt(r) - 'a';
                if(freq[idxR] == 0) uniqueIndex++;
                freq[idxR]++;
                if(freq[idxR] == k) atLeastK++;
                r++;
                while(uniqueIndex > targetIndex) {
                    int idxL = s.charAt(l) - 'a';
                    if(freq[idxL] == k) atLeastK--;
                    freq[idxL]--;
                    if(freq[idxL] == 0) uniqueIndex--;
                    l++;
                }

                if(uniqueIndex==targetIndex && atLeastK==targetIndex) {
                    ans = Math.max(ans, r - l);
                }
            }
        }
        return ans;
    }
}
