package DSASheet.BinarySearch;

public class FindMinimumInsortedArrayII {
    public static void main(String[] args) {
        int[] nums = {2,2,2,0,1};
        int minimum = minimumSortedArrayII(nums);
        System.out.println(minimum);
    }
    private static int minimumSortedArrayII(int[] nums) {
        //brute
//        int n = nums.length;
//        int min = nums[0];
//        for(int i=0; i<n; i++) {
//            min = Math.min(min,nums[i]);
//        }
//        return min;
        //optimized
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while(left<right) {
            int mid = left + (right - left) / 2;

            if(nums[left] == nums[mid] && nums[right] == nums[mid]) {
                left++;
                right--;
                continue;
            }

            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
