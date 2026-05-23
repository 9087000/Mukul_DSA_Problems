package DSASheet.BinarySearch;

public class SplitLargestSubArray {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int k = 2;
        int splitArray = splitArrays(nums,k);
        System.out.println(splitArray);
    }
    private static int splitArrays(int[] nums, int k) {
        //brute
//        int min = 0;
//        int sum = 0;
//        for(int num : nums) {
//            min = Math.max(min, num);
//            sum += num;
//        }
//
//        for(int candidate = min; candidate<=sum; candidate++) {
//            int subArrays = 1;
//            int currentSum = 0;
//            for(int num : nums) {
//                if(currentSum + num <= candidate) {
//                    currentSum+=num;
//                } else {
//                    subArrays++;
//                    currentSum = num;
//                }
//            }
//
//            if(subArrays<=k) {
//                return candidate;
//            }
//        }
//        return -1;
        //optimized
        int min = 0;
        int sum = 0;
        for(int num : nums) {
            min = Math.max(min, num);
            sum+=num;
        }

        int left = min;
        int right = sum;
        int ans  = 0;

        while(left<=right) {
            int mid = left + (right - left) / 2;

            int subArrays = 1;
            int currentSum = 0;

            for(int num : nums) {
                if(currentSum + num <= mid) {
                    currentSum+=num;
                } else {
                    subArrays++;
                    currentSum = num;
                }
            }

            if(subArrays<=k) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;

    }
}
