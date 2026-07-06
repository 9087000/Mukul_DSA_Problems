package DSASheet.RecursionAndBackTracking;
import java.util.ArrayList;
import java.util.List;
public class Permutations {
    public static void main(String args[]) {
        int[] nums = {1,2,3};
        List<List<Integer>> permutate = permutations(nums);
        System.out.println(permutate);
    }
    private static List<List<Integer>> permutations(int[] nums) {
        //brute
        //Use current.contains() to check whether the element is already used
        // result= []
        // current= []
        // solve(nums, current, result)
        // solve(nums, current, result) :
        // if(current.size() == nums.length) :
        // add the copy of current to result
        // return
        // for  nums from 0 to nums.length  -1 :
        // current.add(nums[i])
        // solve(nums, current, result)
        // current.remove(current.size() - 1)
        // return result
        // T.C : o( n! * n)
        // S.C : o(n)
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> current = new ArrayList<>();
//
//        solve( nums, current, result);
//
//        return result;
        //optimized
        // use boolean[] used instead of current.contains
        // result = []
        // current = []
        // boolean used array of size n
        // solve(nums, used, current, result)
        // if(current.size() == nums.length)
        // add copy of current to result
        // return
        // for nums from 0 to nums.length - 1:
        // if(used[i]):
        // continue
        // add nums[i] to current
        // used[i] = true
        // recursion
        // solve(nums, used, current, result)
        // remove the last
        // used[i] = false
        // T.C : o(n! * n)
        // S.C : o(n)
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        boolean[] used = new boolean[nums.length];

        solve(nums, used, current, result);

        return result;
    }

    private static void solve(int[] nums, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=0; i<nums.length; i++) {
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
//    private static void solve(int[] nums, List<Integer> current, List<List<Integer>> result) {
//        if(current.size() == nums.length) {
//            result.add(new ArrayList<>(current));
//            return;
//        }
//        for(int i=0; i<nums.length; i++) {
//            if(current.contains(nums[i])) {
//                continue;
//            }
//            current.add(nums[i]);
//            solve(nums, current, result);
//            current.remove(current.size() - 1);
//        }
//    }
}
