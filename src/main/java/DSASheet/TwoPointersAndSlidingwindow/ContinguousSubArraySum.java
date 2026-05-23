package DSASheet.TwoPointersAndSlidingwindow;

import java.util.HashMap;
import java.util.Map;
//We will use prefixsum + hashmap
//core idea : 0 -> -1 and 1 -> 0 equal number of 0 and 1 have the sum as 0 in between
//prefix sum -> store first index
//if the same prefix sum appears again, then subarray between them have sum = 0
// 1 0 1
// -1 0 -1 sum = 0
//freq.put(0,-1);
//having subArrays starting from 0
//Convert 0 to -1
//Maintain running sum
//Create Hashmap
//The prefix sum store the first index
//if prefix sum appears again
//calculate length
//update maxLength
public class ContinguousSubArraySum {
    public static void main(String[] args) {
        int[] nums = {0,1};
        int maxLen = maxLength(nums);
        System.out.println(maxLen);
    }

    private static int maxLength(int[] nums) {
        //brute force
        //TLE for larger inputs
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            int sum = 0;
//            for (int j = i; j < nums.length; j++) {
//                sum += nums[j] == 0 ? -1 : 1;
//                if (sum == 0) {
//                    count = Math.max(count, j - i + 1);
//                }
//            }
//        }
//        return count;
        //optimized
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0,-1);

        int sum  =0;
        int maxLen = 0;

        for(int i =0; i<nums.length; i++) {
            sum+= (nums[i] == 0) ? -1 :1;

            if(freq.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - freq.get(sum));
            } else {
               freq.put(sum , i);
            }
        }
        return maxLen;
    }
}
