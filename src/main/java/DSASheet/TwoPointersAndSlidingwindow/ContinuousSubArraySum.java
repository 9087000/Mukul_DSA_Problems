package DSASheet.TwoPointersAndSlidingwindow;

import java.util.HashMap;
import java.util.Map;
//We will use Prefix sum + hashmap
//Returns true if continuous array contains
//length >=2
//sum of subArray is divisible by k
//If the two prefix sum have same remainder that is divisible by k
//prefixSum2 % k == prefixSum1 % k
//then
//prefixsum2 - prefixSum1 % k == 0
//firstIndex -> first seen Index
//currentIndex - firstIndex >=2
//create a hashmap
//freq.put(0,-1) handles subarray starting from 0
//Maintain running sum of subArray
//For each element at i
// sum+= nums[i]
// int remainder = sum % k
// if(freq.containsKey(remainder))
//  if(i - firstIndex >=2)
//  return true
// else store remainder -> i
//return false
public class ContinuousSubArraySum {
    public static void main(String[] args) {
        int[] nums = {23,2,4,6,7};
        int k = 6;
        boolean subArray = continuouSubArray(nums, k);
        System.out.println(subArray);
    }

    private static boolean continuouSubArray(int[] nums, int k) {
//        for(int i=0; i<nums.length; i++) {
//            int sum = 0;
//            for(int j=i; j<nums.length; j++) {
//                sum+=nums[j];
//
//                if(j - i + 1>=2 && sum%k==0) {
//                    return true;
//                }
//            }
//        }
//        return false;
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0,-1);

        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];

            int remainder = sum % k;

            if(remainder < 0) {
                remainder+=k;
            }
            if(freq.containsKey(remainder)) {
                if(i - freq.get(remainder)>=2) {
                    return true;
                }
            } else {
                freq.put(remainder, i);
            }
        }
        return false;
    }
}
