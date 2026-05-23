package DSASheet.TwoPointersAndSlidingwindow;

import java.util.HashMap;
import java.util.Map;
//Prefix sum + hashmap we will use
//If the two prefix sum have the same remainder that is divisible by k , the subarray between is also divisible by k
//(prefix2 - prefix1) % k =0
//then
//prefix2% k = prefix1% k
//Create a hashmap to store frequency of reaminder
//intialize
//map.put(0,1)
//The subarray sum is starting from 0
//Maximize sum
//sum+=nums[i]
//Compute remainder
//int remainder = sum - k;
//Calculate negative remainder
//if(remainder < 0)
//remainder+=k
//if remainder already exists
// count+=freq.get(remainder)
//update frequnecy
//Java for calcualting remainder
// -2 % 3 == 0
//then on remainder of it will be 5
//formula before
// remainder = (sum % k + k) % k == 0
//or
//if(remainder < 0)
//remainder+=k
public class SumDivisibleByK {
    public static void main(String[] args) {
        int[] nums = {4,5,0, -2, -4, 1};
        int k = 5;
        int ans = sumDivisible(nums, k);
        System.out.println(ans);
    }
    private static int sumDivisible(int[] nums, int k) {
        //brute force
        //fails for larger test cases
        int count = 0;
        for(int i =0; i<nums.length; i++) {
            int sum = 0;
            for(int j=i; j<nums.length; j++) {
                sum+=nums[j];
                if(sum % k == 0) {
                    count++;
                }
            }
        }
        return count;
//       //optimized approach
//        Map<Integer, Integer> freq = new HashMap<>();
//        freq.put(0,1);
//
//        int sum = 0;
//        int count = 0;
//        for(int i=0; i<nums.length; i++) {
//            sum+=nums[i];
//
//            int remainder = sum  % k;
//
//            if(remainder< 0) {
//                remainder+=k;
//            }
//
//            if(freq.containsKey(remainder)) {
//                count+=freq.get(remainder);
//            }
//
//            freq.put(remainder, freq.getOrDefault(remainder, 0) + 1);
//        }
//
//        return count;

    }
}
