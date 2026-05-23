package DSASheet.Heap;

import java.util.Arrays;

public class JumpGameI {
    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        boolean jump = jumpGame(nums);
        System.out.println(jump);
    }
    private static boolean jumpGame(int[] nums) {
        //brute
        // dp[i] is where the ith index is reachable
        // You can also store min jumps
        // int n = nums.length
        // Create a dp array with length
        // Fill array with o  to infinity
        // for each array from i to n - 1:
        // if dp[i] == Integer.MAX_VALUE continue
        // for each array from j tp i + nums[i] and j <n :
        // dp[j] = Math.min(dp[j], dp[i] + 1)
        // return dp[n-1] != Integer.MAX_VALUE
        // T.C: o(n2)
        // S.C: o(n)
//        int n = nums.length;
//        int[] dp = new int[n];
//
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0
//        for(int i=0; i<n; i++) {
//             if(dp[i] == Integer.MAX_VALUE) continue;
//            for(int j=i+1; j<=i+nums[i] && j<n; j++) {
//                dp[j] = Math.min(dp[j], dp[i] + 1);
//            }
//        }
//
//        return dp[n-1] != Integer.MAX_VALUE;
        // optimized
        // Track the farthest index to reach
        // farthest = 0;
        // for each array in i to n
        // if (i > farthest[i]) -> cannnot reach index -> return false
        // farthest = Math.max(farthest, i + nums[i])
        //  return true
        // t.C: o(n)
        // s.c: o(1)
        int n = nums.length;
        int farthestEnd = 0;

        for(int i=0; i<n; i++) {
            if(i>farthestEnd) {
                return false;
            }
            farthestEnd = Math.max(farthestEnd, i + nums[i]);
        }

        return true;
    }
}
