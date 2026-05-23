package DSASheet.TwoPointersAndSlidingwindow;

import java.util.HashMap;
import java.util.Map;
//Core idea:
// Prefix sum + hashMap
// Length of longest variant subArray
// sum of subArray is equals to k
// prefixSum[j] - prefixSum[i] == k
// the subArray of i + 1 and j has the sum = k
// prefixSum[i] = prefixSum[j] - k
// First index -> it is where index first seen
// length = currentIndex - firstIndex
// previous index has longest subArray
//Create a Hash map
//freq.put(0 , -1) handles subArray starting from 0
//sum  = 0 , length  =0;
// For every subArray at i:
//  sum += nums[i]
//  need = sum - k
// if freq contains need
// i - freq.get(need)
// update maxLen
// else
// store the sum -> i
// return length
public class MaxSizeSubArray {
    public static void main(String[] args) {
        int[] nums = {1,-1,5,-2,3};
        int k = 3;
        int len = maxLength(nums, k);
        System.out.println(len);
    }

    private static int maxLength(int[] nums, int k) {
        //brute force
//        int count = 0;
//        for(int i=0; i<nums.length; i++) {
//            int sum = 0;
//            for(int j = i; j<nums.length; j++) {
//               sum+=nums[j];
//                if(sum == k) {
//                    count = Math.max(count, j - i + 1);
//                }
//            }
//        }
//        return count;
        //optimized approach
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0,-1);

        int sum = 0;
        int maxLen  = 0;

        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];

            int need = sum - k;

            if(freq.containsKey(need)) {
                maxLen = Math.max(maxLen, i - freq.get(need));
            }

            if(!freq.containsKey(sum)) {
                freq.put(sum, i);
            }
        }
        return maxLen;
    }
}
