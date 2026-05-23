package DSASheet.TwoPointersAndSlidingwindow;

import javax.swing.tree.TreeCellRenderer;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//Pattern used is prefix sum for transforming subArray sum, and merge sort approach with two pointer to provide counting for timeo )n longn) time
// Subarray sum -> prefix Sum difference
// lower < prefixsum[j] - prefixsum[i] < upper
// left = earlier prefix sum
// right = later prefix sum
// Both sorted
// Count all the valid pairs
// For each val left:
// valid right val range:
// left + lower < right < left+ upper
// jstart = first valid pairs
// jend = first invalid pairs
// count+= (jend - jstart);
//Merge case:
// Merge sorted
// copy on recusrion works
public class CountRangeOfsum {
    public static void main(String[] args) {
        int[] nums = {-2,5,-1};
        int upper = 2;
        int lower = -2;
        int rangeSum=  countRange(nums,upper, lower);
        System.out.println(rangeSum);
    }
    private static int countRange(int[] nums, int upper, int lower) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            int sum = 0;
            for(int j=i; j <nums.length; j++) {
                sum+=nums[j];
                if(sum <= upper && sum >= lower) {
                    count++;
                }
            }
        }
        return count;

        //optimized approach
//        Map<Integer , Integer> freq = new TreeMap<>();
//        freq.put(0,1);
//        int sum = 0;
//        int count = 0;
//
//        for(int i=0; i<nums.length; i++) {
//            sum+=nums[i];
//
//            int need = sum - upper;
//            int need1 = sum - lower;
//            for(int freqCount: ((TreeMap<Integer, Integer>) freq)
//                    .subMap(need, true, need1, true)
//                            .values()) {
//                count+=freqCount;
//            }
//
//
//            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
//
//        }
//        return count;
//        int count= 0;
//        long[] prefix = new long[nums.length + 1];
//        for(int i=0; i<nums.length; i++) {
//            prefix[i+ 1] = prefix[i] + nums[i];
//        }
//        count = mergeSort(prefix, 0, prefix.length - 1, lower, upper);
//
//        return count;

    }

    static int mergeSort(long[] prefix, int left, int right, int lower, int upper) {
        if(left>= right) return 0;
        int mid = left + (right - left) / 2;
        int count = 0;
        count+=mergeSort(prefix, left, mid, lower,upper);
        count+=mergeSort(prefix, mid+1, right, lower, upper);
        int jStart = mid + 1;
        int jEnd = mid + 1;

        for(int i = left; i<=mid; i++) {
            while(jStart <= right && prefix[jStart] - prefix[i] < lower) {
                jStart++;
            }
            while(jEnd<= right && prefix[jEnd] - prefix[i] <= upper) {
                jEnd++;
            }
            count+=(jEnd - jStart);
        }

        long[] temp = new long[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i<=mid && j<=right) {
            if(prefix[i] <= prefix[j]) {
                temp[k++] = prefix[i++];
            } else {
                temp[k++] = prefix[j++];
            }
        }

        while(i<=mid) temp[k++] = prefix[i++];
        while(j<=right) temp[k++] = prefix[j++];

        for(int p=0; p<temp.length; p++) {
            prefix[left + p] = temp[p];
        }

        return count;
    }
}
