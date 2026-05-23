package DSASheet.TwoPointersAndSlidingwindow;

import java.util.HashMap;
import java.util.Map;
//We will use prefix sum + hashMap we will use state compression trick
//Let
// c1= number of 0's
// c2 = number of 1's
// c3 = number of 2's
//  we want
// c1=c2=c3
// instead we track difference
// diff1 = c2- c1;
// diff2 = c3- c1;
// if the same(diff1, diff2) appears again then the subarray has
// equal number of 0's , 1's and 2's
// key = diff1 + "#" + diff2;
// value = first index where state occured
//map.put("0#0" , -1)
// this includes subarray starting from 0
//Intialize counters for 0,1,2
//create hashMap
// intialize state (0#0) -> -1
// Traverse the array
// update the count
// Compute the difference
//build the key
//if key exists -> update the maxLength
// else store index
public class LongestSubArray {
    public static void main(String[] args) {
        int[] nums = {0,1,0,2,0,1,0};
        int count = LongestSub(nums);
        System.out.println(count);
    }

    private static int LongestSub(int[] nums) {
//        int n = nums.length;
//        int count = 0;
//        for(int i=0; i<n; i++) {
//            int c1= 0, c2 = 0, c3 = 0;
//            for(int j=i; j<n; j++) {
//                if(nums[j] == 0) c1++;
//                if(nums[j] == 1) c2++;
//                if(nums[j] == 2) c3++;
//
//                int len = j - i + 1;
//                if(len %3 == 0 && c1 == c2 && c2 == c3) {
//                    count += Math.max(count, j - i  + 1);
//                }
//            }
//        }
//        return count;
        int c1 =0, c2= 0, c3 = 0;
        int count = 0;
        Map<String, Integer> freq = new HashMap<>();
        freq.put("0#0" , -1);
        for(int i =0; i<nums.length; i++) {

           if(nums[i] == 0) c1++;
           else if(nums[i] == 1) c2++;
           else if(nums[i] == 2) c3++;

           int diff = c2 - c1;
           int diff1 = c3 - c1;
           String key =  diff + "#" + diff1;

           if(freq.containsKey(key)) {
               int prevIndex = freq.get(key);
               count = Math.max(count, i - prevIndex);
           } else {
               freq.put(key, i);
           }


        }
        return count;
    }
}
