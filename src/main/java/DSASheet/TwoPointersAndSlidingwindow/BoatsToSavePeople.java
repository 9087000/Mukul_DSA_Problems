package DSASheet.TwoPointersAndSlidingwindow;

import java.util.Arrays;

public class BoatsToSavePeople {
    public static void main(String args[]) {
        int[] nums = {3,5,3,4};
        int k = 5;
        int boats = boatsToSave(nums, k);
        System.out.println(boats);
    }

    private static int boatsToSave(int[] nums, int k) {
          int n = nums.length;
          boolean[] used = new boolean[n];
          int count = 0;

          for(int i=0; i<n; i++) {
              if(used[i]) continue;;

              used[i] = true;

              for(int j=n-1; j>i; j--) {
                  if(!used[j] && nums[i] + nums[j] <= k) {
                      used[j] = true;
                      break;
                  }
              }
              count++;
          }
          return count;
//        Arrays.sort(nums);
//        int left = 0;
//        int right = nums.length - 1;
//        int boatCount = 0;
//        while(left<=right) {
//            int sum = nums[left] + nums[right];
//
//            if(sum <= k) {
//                left++;
//            }
//                right--;
//                boatCount++;
//        }
//        return boatCount;
    }
}
