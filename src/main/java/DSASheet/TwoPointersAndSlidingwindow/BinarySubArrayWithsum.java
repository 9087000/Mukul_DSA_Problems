package DSASheet.TwoPointersAndSlidingwindow;

import java.util.HashMap;
import java.util.Map;

public class BinarySubArrayWithsum {
    public static void main(String[] args) {
        int[] nums = {0,0,0,0,1};
        int goal = 2;
        int Sum = binarySubArraySum(nums, goal);
        System.out.println(Sum);
    }

    private static int binarySubArraySum(int[] nums, int goal) {
        //brute force
//        int count = 0;
//        for(int i=0; i<nums.length; i++) {
//            int sum = 0;
//            for(int j=i; j<nums.length; j++) {
//                sum+=nums[j];
//                if(sum == goal) {
//                    count++;
//                }
//            }
//        }
//        return count;

        //Optimized approach
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0,1);

        int sum = 0;
        int count = 0;

        for(int i=0; i<nums.length; i++) {
            sum+=nums[i];
            int need = sum - goal;
            if(freq.containsKey(need)) {
                count+=freq.get(need);
            }

            freq.put(sum, freq.getOrDefault(sum , 0) + 1);
        }
        return count;
    }
}
