package DSASheet.RecursionAndBackTracking;

import java.util.Arrays;

public class PartitiontoKequalSum {
    public static void main(String[] args) {
        int[] nums = {4,3,2,3,5,2,1};
        int k = 4;
        boolean partition = partitiontoKequalsSum(nums, k);
        System.out.println(partition);
    }
    //optimized
    // Same as recursion avoid unnecessary branches
    // sort the bucket
    // Pick the largest number
    // if largest number < target return false
    // Skip duplicate in empty bucket sent
    // Find the sum
    // if(sum % k != 0)
    // return false
    // target = sum / k
    // sort the buckets
    // check for largest number < target
    // if(nums[nums.length - 1] < target)
    // false
    // create a bucket array sub of size k
    // pick current largest number
    // Try placing it in from 0 to k - 1
    //  if sub[i] + num > target
    // continue
    // place it
    // sub[i] += num
    // if recursion is true
    // return true
    // bakcTrack
    // sub[i] -= num
    // if sub[i] == 0
    // break
    // T.C : o(n^k)
    // S.C : o(n + k)
    // sum = 0
    // for int num : nums
    // sum+=num
    // if(sum % k != 0)
    // return false
    // target = sum / k
    // if(nums[nums.length - 1] > target)
    // false
    // Arrays.sort(nums)
    // int[] sub  new int[k]
    // return solve(nums.length - 1, nums, sub, target, k)
    // solve(int index, int[] nums, int[] sub, int target, int k):
    // if(index <0) :
    // for int i=0; i<sub.length; i++
    // if(sub[i] != target) return false
    // return true
    // n = nums[index]
    // for int i=0; i<k; i++
    // if(sub[i] + n > target)
    // continue
    // sub[i]+=n
    // if(Solve(index-1, nums, sub, target, k))
    // true
    // sub[i]-=n
    // if(sub[i] == 0)
    // break
    // return false
    private static boolean partitiontoKequalsSum(int[] nums, int k) {
        int sum = 0;

        for(int num : nums) {
            sum+=num;
        }

        if(sum % k !=0) {
            return false;
        }

        int target = sum / k;
        Arrays.sort(nums);
        if(nums[nums.length-1] > target) {
            return false;
        }
        int[] sub = new int[k];

        return solve(nums.length - 1, nums, sub, target, k);
    }
    private static boolean solve(int index, int[] nums, int[] sub, int target, int k) {
        if(index <0) {
            for(int i=0; i<sub.length; i++) {
                if(sub[i] != target) return false;
            }
            return true;
        }

        int subr = nums[index];

        for(int i=0; i<k; i++) {
            if(sub[i] + subr > target) {
                continue;
            }

            sub[i]+=subr;

            if(solve(index-1, nums, sub, target, k)) {
                return true;
            }

            sub[i]-=subr;

            if(sub[i] == 0) {
                break;
            }
        }

        return false;
    }
    //brute
    // Same as matching sticks to square . but instead of 4 sides
    // k buckets
    // Each bucket have
    // target = totalSum / k
    // find sum
    // if sum % k != 0
    // return false
    // target = sum / k
    // create the sub array of size k
    // recurse from 0
    // sub[] = new int[k]
    // pick current number
    // num = nums[index]
    // Try placing in index from 0 to k - 1
    // if sub[i] + num <= target
    // place it
    // sub[i] + = num
    // if the recursion returns true:
    // return true
    // backtrack
    // sub[i] - = num
    // Check if all side are valid:
    // check for all k sides == target
    // T.C : o(k^n * k)
    // S.c: o(n + k)
//    private static boolean partitiontoKequalsSum(int[] nums, int k) {
//        int sum = 0;
//
//        for(int num : nums) {
//            sum+=num;
//        }
//
//        if(sum % k != 0) {
//            return false;
//        }
//
//        int target = sum / k;
//        int[] ksub = new int[k];
//
//        return solve(0, nums, ksub, target ,k);
//    }
//    private static boolean solve(int index, int[] nums, int[] ksub, int target, int k) {
//        if(index == nums.length) {
//            for(int i=0; i<ksub.length; i++) {
//                if(ksub[i] != target) return false;
//            }
//
//            return true;
//        }
//
//        int sub = nums[index];
//
//        for(int i=0; i<k; i++) {
//            if(ksub[i] + sub <= target) {
//                ksub[i]+=sub;
//
//                if(solve(index + 1, nums, ksub, target, k)) {
//                    return true;
//                }
//
//                ksub[i]-=sub;
//            }
//        }
//
//        return false;
//    }
}
