package DSASheet.TwoPointersAndSlidingwindow;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> sum = threeSum(nums);
        System.out.println(sum);
    }
    private static List<List<Integer>> threeSum(int[] nums) {
//        Set<List<Integer>> set = new HashSet<>();
//        for(int i=0; i<nums.length; i++) {
//            for(int j=i +1; j<nums.length; j++) {
//                for(int k=j + 1 ; k<nums.length; k++) {
//                    if(nums[i] + nums[j] + nums[k] == 0 ) {
//                          List<Integer> li = Arrays.asList(nums[i], nums[j], nums[k]);
//                          Collections.sort(li);
//                          set.add(li);
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(set);
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    set.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
