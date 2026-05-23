package DSASheet.TwoPointersAndSlidingwindow;

import java.util.HashMap;
import java.util.Map;
//We will use prefix sum + hashMap
//core idea:
//Before
// currentSum - previousSum = k
// then :
// previousSum = currentSum - k
//so at each index we check whether currentSum - k is seen before
// freq -> frequency of prefix sum
// We store frequencies (not index) beacuse:
// same prefix sum can appear multiple times -> Mutiple valid subArrays
//freq.put(0,1)
//why?
// We store prefix sum before start of array
// All the valid subarray starting from 0 will gets counted
//steps:
// sum+=nums[i]
// int need = sum - k
//if need exists
//count+=freq.get(need)
//update freq
//return count
//beacuse we need previous prefix sum first, if we update map first the current sum becaome previous prefix sum overcounting
// Update the past then present
//Why sliding window fails?
//Negative value are allowed
//Sum does not change monotonically
//Cannot determinstictly Expand left / shrink right
public class SumOfArraysDivisibleByK {
    public static void main(String[] args) {
        int[]  nums = {1,1,1};
        int k = 2;
        int subArray = subArraySum(nums, k);
        System.out.println(subArray);
    }

    private static int subArraySum(int[] nums, int k) {
        //brute force
//        int count = 0;
//        for(int i=0; i<nums.length; i++) {
//            int sum = 0;
//            for(int j=i; j<nums.length; j++) {
//                sum+=nums[j];
//                if(sum==k) {
//                    count++;
//                }
//            }
//        }
//        return count;
        //Optimized approach
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        freq.put(0,1);
        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
            int need = sum - k;
            if(freq.containsKey(need)) {
                count+=freq.get(need);
            }
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
