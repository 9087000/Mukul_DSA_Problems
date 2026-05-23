package DSASheet.BinarySearch;

import java.util.Arrays;

public class FirstAndEndingposition {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] result = search(nums, target);
        System.out.println(Arrays.toString(result));
    }
    private static int[] search(int[] nums, int target) {
        //brute
//        int n=nums.length;
//        int first = -1;
//        int last = -1;
//        for(int i=0; i<n; i++) {
//            if(nums[i] == target) {
//                if(first == -1) {
//                    first = i;
//                }
//                last = i;
//            }
//        }
//        return new int[]{first, last};
        //optimized
       int first = findFirst(nums, target);
       int last = findLast(nums,target);
       return new int[]{first,last};
    }
    private static int findFirst(int[] nums, int target) {
        int n = nums.length;
        int ans = -1;
        int left = 0;
        int right = n - 1;
        while(left<=right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                ans = mid;
                right = mid - 1;
            }
            else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
    private static int findLast(int[] nums, int target) {
        int n = nums.length;
        int ans = -1;
        int left = 0;
        int right = n - 1;
        while(left<=right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) {
                ans = mid;
                left = mid + 1;
            }
            else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
