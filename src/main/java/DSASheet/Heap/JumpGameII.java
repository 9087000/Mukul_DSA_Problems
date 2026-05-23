package DSASheet.Heap;

public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jumpGameII(nums));
    }
    private static int jumpGameII(int[] nums) {
        //brute
        //Each index represents maximum number of jumps from that index
        // dp[i] = minimum number of jumps to reach index i
        // initialize n = nums.length
        // create dp array:
        // Fill dp value with 0 to infinity
        // for each value  of i in range of 0 to n
        //  for each value of j in range of i + 1 to j + nums[i] and if j < n
        // dp[j] = Math.min(dp[j], dp[i] + 1);
        // return dp[n-1]
        // T.c: o(n2)
        // S.c: o(n)
//        int n = nums.length;
//        int[] dp = new int[n];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//
//        for(int i=0; i<n ;i++) {
//            for(int j=i+1; j<=i + nums[i] && j<n; j++) {
//                dp[j] = Math.min(dp[j], dp[i] + 1);
//            }
//        }
//
//        return dp[n - 1];
        //Optimized
        // Each jump value tells maximum jump length
        // jumps = number of jumps range
        // currentEnd = end of current jump range
        // farthestEnd = farthest index from the current jump range
        // farthestEnd = Math.max(farthestEnd, i + nums[i]);
        // if i == currentEnd
        // range end and from that you can start jumping
        // if one jump and from that reach index 2
        // T.C: o(n)
        // S.C: o(1)
        int n = nums.length;
        int jums = 0;
        int current = 0;
        int farthest = 0;

        for(int i=0; i<n-1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if(i == current) {
                jums++;
                current = farthest;
            }
        }
        return jums;
    }
}
