package DSASheet.TwoPointersAndSlidingwindow;

import java.util.HashMap;
import java.util.Map;
//We does not care about value , we care only about numbers
//odd -> contributes 1
//even -> contributes 0
//Transformation
//2,2,2,1,2,2,1,2,2,2
//Transformed
//0,0,0,1,0,0,1,0,0,0
//Then becomes
//Count number of subArrays == k
// this becomes subArrays sum equals to k
//brute force
//For Every subArray
//check every subArray contains odd then increment odd count
//if(sum == k) Valid -> increment count
//optimized approach
//prefix sum + hashMap
//formula
//prefixSum[j] - prefixSum[i] = k
//int need = sum - k
//prefixSum -> store frequency
//create a hashMap
//freq.put(0,1) handles subArray Starting from 0
//Maintain running sum of sum with oddCount
//int need = sum - k
//for every subArray if it contains:
//if(freq.containsKey(need))
//increment count
//update frequency
//return count
public class NiceSubArrays {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        int sum = niceSubArray(nums, k);
        System.out.println(sum);
    }

    private static int niceSubArray(int[] nums, int k) {
        //brute force
//        int count = 0;
//        for(int i=0; i<nums.length; i++) {
//            int sum = 0;
//            for(int j=i; j<nums.length; j++) {
//               sum+=((nums[j] % k == 1)) ? 1 : 0;
//                if(sum  == k) {
//                    count++;
//                }
//            }
//        }
//        return count;
        //optimize approach
//        Map<Integer, Integer> freq = new HashMap<>();
//        freq.put(0,1);
//        int sum = 0;
//        int count = 0;
//
//        for(int i=0; i<nums.length; i++) {
//            if(nums[i] % 2 == 1) {
//                sum++;
//            }
//
//            int need = sum - k;
//            if(freq.containsKey(need)) {
//                count+=freq.get(need);
//            }
//
//            freq.put(sum, freq.getOrDefault(sum , 0) + 1);
//
//
//        }
//        return count;
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0,1);
        int sum = 0;
        int count = 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] % 2 == 1) {
                sum++;
            }

            int need = sum - k;
            if(freq.containsKey(need)) {
                count+=freq.get(need);
            }

            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
