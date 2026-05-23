package DSASheet.TwoPointersAndSlidingwindow;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int sorted = removeDuplicate(nums);
        System.out.println(sorted);
    }
    private static int removeDuplicate(int[] nums) {
//        int n = nums.length;
//        for(int i=0; i<n-1; i++) {
//            if(nums[i] == nums[i+1]) {
//                for (int j = i + 1; j < n - 1; j++) {
//                    nums[j] = nums[j + 1];
//                }
//                n--;
//                i--;
//            }
//        }
//        return n;
        int slow = 0;

        for(int fast=1; fast<nums.length; fast++) {
            if(nums[fast] != nums[slow]) {
                nums[slow+1] = nums[fast];
                slow++;
            }
        }
        return slow + 1;
    }
}
