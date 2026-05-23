package DSASheet.BinarySearch;

public class SearchInsertedPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        int search = searchIndex(nums, target);
        System.out.println(search);
    }
    private static int searchIndex(int[] nums, int target) {
        //brute
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(nums[i] >= target) {
                return  i;
            }
        }
        return n;
        //optimized
//        int n = nums.length;
//        int left = 0;
//        int right = n - 1;
//
//        while(left<=right) {
//            int mid = left + (right - left) / 2;
//
//            if (nums[mid] == target) return  mid;
//            else if(nums[mid] < target) left = mid + 1;
//            else right = mid - 1;
//        }
//        return left;
    }
}
