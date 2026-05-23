package DSASheet.BinarySearch;

public class SearchInRotatedArrayII {
    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 3;
        boolean search = searchinRotated(nums, target);
        System.out.println(search);
    }
    private static boolean searchinRotated(int[] nums, int target) {
        //brute
//        int n = nums.length;
//        for(int i=0; i<n; i++) {
//            if(nums[i] == target) {
//                return true;
//            }
//        }
//        return false;
        //optimized
        int n = nums.length;
        int left = 0;
        int right = n -1;
        while(left<=right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) return true;

            if(nums[mid] == nums[left] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if(nums[left] <= nums[mid]) {
                if(nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(nums[mid] < target && target<= nums[right]) {
                    left = mid  + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
