package DSASheet.BinarySearch;

public class MedianofTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        double median = medianOfTwoSorted(nums1, nums2);
        System.out.println(median);
    }
    private static double medianOfTwoSorted(int[] nums1, int[] nums2) {
        //brute
//        int m = nums1.length;
//        int n = nums2.length;
//
//        int[] merged = new int[m + n];
//
//        int i =0, j=0, k=0;
//
//        while(i<m && j<n) {
//            if(nums1[i] <= nums2[j]) {
//                merged[k++] = nums1[i++];
//            } else {
//                merged[k++] = nums2[j++];
//            }
//        }
//
//        while(i<m) {
//            merged[k++] = nums1[i++];
//        }
//
//        while(j<n) {
//            merged[k++] = nums2[j++];
//        }
//
//        int total = m + n;
//
//        if(total % 2 == 1) {
//            return (merged[total/2]);
//        } else {
//            return (merged[total/2] - 1) + (merged[total/2]) / 2.0;
//        }
        //optimized
        if(nums1.length > nums2.length) {
            return medianOfTwoSorted(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int left = 0;
        int right = m;

        while(left<=right) {
            int cut1 = left + (right - left) / 2;
            int cut2  = (m + n + 1) / 2 - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 -1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            if(l1<=r2 && l2<=r1) {
                if((m + n) % 2 == 1) {
                    return Math.max(l1, l2);
                } else {
                    return (Math.max(l1, l2) + Math.min(r1,r2)) / 2.0;
                }
            } else if(l1>r2) {
                right = cut1 - 1;
            } else {
                left = cut1 + 1;
            }
        }
        return 0.0;
    }
}
