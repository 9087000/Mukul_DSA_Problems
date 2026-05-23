package DSASheet.BinarySearch;

public class FindSmallestDivisor {
    public static void main(String[] args) {
        int[] nums = {1,2,5,9};
        int threshold = 6;
        int divisor = smallestDivisor(nums, threshold);
        System.out.println(divisor);
    }

    private static int smallestDivisor(int[] nums, int threshold) {
        //brute
//        int maxNums = 0;
//
//        for(int num : nums) {
//            maxNums = Math.max(maxNums, num);
//        }
//
//        for(int k=1; k<=maxNums; k++) {
//            int sum = 0;
//
//            for(int num : nums) {
//                sum+=(num + k - 1) / k;
//            }
//
//            if(sum<=threshold) {
//                return k;
//            }
//        }
//        return -1;
        //optimized
        int maxNums = 0;
        for(int num : nums) {
            maxNums = Math.max(maxNums, num);
        }

        int left = 1;
        int right = maxNums;
        int ans = 0;

        while(left<=right) {
            int mid = left + (right - left) / 2;

            int sum = 0;

            for(int num: nums) {
                sum+=(num + mid - 1) / mid;
            }

            if(sum<=threshold) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid  + 1;
            }
        }
        return ans;
    }
}
