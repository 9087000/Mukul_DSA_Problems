package DSASheet.RecursionAndBackTracking;

import java.util.*;

public class SubSetsII {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> subset = subSets(nums);
        System.out.println(subset);
    }
    private static List<List<Integer>> subSets(int[] nums) {
        //brute
        // Generate all subsets normally
        // store all subsets using set
        // set will avoid duplicate values
        // nums may contain duplicates
        // sort the nums first
        // create set<List<Integer>> set
        // current = []
        // solve(0, nums, current, set)
        // solve :
        // if(index == nums.length) :
        // add the current to result
        // return
        // skip
        // add the nums[index] to current
        // solve(index+1)
        // remove the last index from current
        // take
        // solve(inxex+1)
        // return new list result with set as parameter
        // T.C : o(2^n * n)
        // S.C : o(2^n * n)
//        Arrays.sort(nums);
//        Set<List<Integer>> result = new HashSet<>();
//        List<Integer> current = new ArrayList<>();
//
//        solve(0, nums, current, result);
//
//        return new ArrayList<>(result);
        //optimized
        // nums may contains duplicates
        // need unique subset only
        // sort the nums first
        // duplicate subset will have adjacent order
        // result = []
        // current  = []
        // solve (0, nums, current, result)
        // return result
        // solve :
        // add current to result
        // for index i to nums.length - 1 :
        // if(i > index && nums[i] == nums[i-1]) :
        // continue;
        // add nums[i] to current
        // solve(i+1)
        // remove the last index from current
        // the main duplicate skip line is :
        // if(i > index && nums[i] == nums[i-1]) :
        // skip the duplicate at same recursive level
        // but allow duplicate in deeper level
        // T.C : o(n* 2^n)
        // S.C : o(n)
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        solve(0, nums, current, result);

        return result;

    }

    private static void solve(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for(int i=index; i<nums.length; i++) {
            if(i>index && nums[i] == nums[i-1]) {
                continue;
            }
            current.add(nums[i]);
            solve(i+1, nums, current, result);
            current.remove(current.size() - 1);
    }
//    private static void solve(int index , int[] nums, List<Integer> current, Set<List<Integer>> result) {
//        if(index == nums.length) {
//            result.add(new ArrayList<>(current));
//            return;
//        }
//
//        current.add(nums[index]);
//        solve(index+1, nums, current, result);
//
//        current.remove(current.size() - 1);
//        solve(index+1, nums, current, result);
    }
}
