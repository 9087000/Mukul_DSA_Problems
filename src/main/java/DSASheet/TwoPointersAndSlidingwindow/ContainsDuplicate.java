package DSASheet.TwoPointersAndSlidingwindow;

import java.util.HashSet;

//Optimized approach sliding window + hash set
//core idea:
// 1) nums[i] == nums[j]
// 2) abs(i - j) < k
// then return
// Duplicate elements are already present in subarray then return true
//steps:
//if(i>k)
// remove the nums[i-k-1] from the set
//adds nums[i] to the set
// add itself returns false if value is already present , then return true
//continue
//return false
//Maintain window of atleast last k elements using Set
//elements are present in window using set
//if the elements are present in set -> duplicate are present within distance k -> return true
//We need to maintain window of size
//if i = k + 1
// then we will remove 0 index that is wrong
// the i flows from k-1 to i -1
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,1};
        int k = 0;
        boolean ans = containsDuplicate(nums, k);
        System.out.println(ans);
    }

//    //brute force
//    private static boolean containsDuplicate(int[] nums, int k) {
//        int n = nums.length;
//
//        for(int i=0; i<n; i++) {
//            for(int j=i + 1; j < n && j<=i+k; j++) {
//                if(nums[i] == nums[j]) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    private static boolean containsDuplicate(int[] nums, int k) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++) {
            set.add(nums[i]);
            if(set.contains(nums[i])) {
                return true;
            }
            if(i>k) {
                set.remove(nums[i - k - 1]);
            }
        }
        return false;
    }
}
