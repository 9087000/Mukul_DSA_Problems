package DSASheet.TwoPointersAndSlidingwindow;
//
public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        int repating = LongestRepatingCharacter(s, k);
        System.out.println(repating);
    }

    private static int LongestRepatingCharacter(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int best = 0;

        for(int right=0; right<s.length(); right++) {
            int c = s.charAt(right) - 'A';
            freq[c]++;

            maxFreq = Math.max(maxFreq, freq[c]);

            while(right - left + 1 - maxFreq > k) {
                int r = s.charAt(left) - 'A';
                freq[r]--;
                left++;
            }

            best = Math.max(best, right-left+1);
        }
        return best;
    }
}
