package DSASheet.RecursionAndBackTracking;

import java.util.*;

public class permutationsII {
    public static void main(String args[]) {
        int[] nums = {1,1,2};
        List<List<Integer>> permutations = permutationsii(nums);
        System.out.println(permutations);
    }
    private static List<List<Integer>> permutationsii(int[] nums) {
        //brute
        // generate all possible permutations
        // use set to remove the duplicates permutations
        //  sort the nums it is optional but good
        // sort(nums)
        // result = set<List<Integer>>
        // current = []
        // boolean[] used  is size of nums length n
        // solve(nums, used, current, result)
        // return new ArrayList<>(result)
        // solve(nums, used, current, result) :
        // if(current.size() == nums.length):
        // add the copy of current to result
        // return
        // for i from 0 to nums.length - 1 :
        // if (used[i])
        // continue
        // current.add(nums[i])
        // used[i] = true
        // solve(nums, used, current, result)
        // current.remove(current.size() - 1)
        // used[i] = false
        // T.C : o(n! * n)
        // S.C : o(n! * n)
//        Arrays.sort(nums);
//        Set<List<Integer>> result = new HashSet<>();
//        List<Integer> current = new ArrayList<>();
//
//        boolean[] used = new boolean[nums.length];
//        solve(nums, used, current, result);
//
//        return new ArrayList<>(result);
        //optimized
        // generate all possible permutations without duplicates itself
        // sort the nums
        // result = []
        // current = []
        // used is boolean of size n
        // solve(nums, used, current, result)
        // return result
        // solve(nums, used, current, result):
        // if(current.size() == nums.length) :
        // add the copy of  current to result
        // return
        // for i from 0 to nums.length  -1 :
        // if(used[i]):
        // continue
        // if(i>0 && nums[i] == nums[i - 1] && !used[i-1]) :
        // continue
        // current.add(nums[i])
        // used[i] = true
        // solve(nums, used, current, result)
        // current.remove(current.size() - 1)
        // used[i] = false
        //duplicate skip line
        // if(i>0 && nums[i] == nums[i - 1] && !used[i-1]) :
        // current value should be same as previous value
        // previous duplicate does not have this value
        // skip current duplicate
        // T.C: o(n! * n)
        // S.C : o(n)
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        solve(nums, used , current, result);

        return result;
    }
    private static void solve(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(i>0 && nums[i] == nums[i - 1] && !used[i-1]) {
                continue;
            }
            if(used[i]) {
                continue;
            }
            current.add(nums[i]);
            used[i] = true;
            solve(nums, used, current, result);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
//    private static void solve(int[] nums, boolean[] used, List<Integer> current, Set<List<Integer>> result) {
//        if(current.size() == nums.length) {
//           result.add(new ArrayList<>(current));
//           return;
//        }
//        for(int i=0; i<nums.length; i++) {
//            if(used[i]) {
//                continue;
//            }
//            current.add(nums[i]);
//            used[i] = true;
//            solve(nums, used, current, result);
//            current.remove(current.size() - 1);
//            used[i] = false;
//        }
//    }
}
