package DSASheet.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public static void main(String args[]) {
       int[] nums = {1,2,3};

       List<List<Integer>> list = subSet(nums);

       System.out.println(list);
    }
    private static List<List<Integer>> subSet(int[] nums) {
        //backtrack
        // for every subset we have two choice
        // take it
        // skip it
        // current = current subSet being built
        // result = all subset combined
        // solve (0, nums, current, result)
        //  while(index == nums.length) :
        // store the current subSet built to result
        // return
        // take it
        // add the current subset with nums[index]
        // current.add(nums[index])
        // solve(index + 1, nums, current, result)
        // skip it
        // remove the current.size() - 1
        // current.remove(current.size() -1)
        // solve(index + 1, nums, current, result)
        // T.C : o(n * 2^n)
        // S.C : o(n)
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> current = new ArrayList<>();
//
//        solve(0, nums, current, result);
//
//        return result;
        //bit manipulation
        // Every subset is represented using bit manipulation
        // result= []
        // for mask from 0 to 1 << n - 1:
        // current = []
        // for index from 0 to n -1 :
        // check whether the indexth being set
        // if(mask & (1<< index) !=0)
        // add current with nums[index]
        // add current to result
        // T.C : o(n * 2^n)
        // S.C : o(1)
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for(int i=0; i< (1<<n); i++) {
            List<Integer> subset = new ArrayList<>();
            for(int j=0; j<n; j++) {
                if((i & (1<<j)) > 0 ) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }

    private static void solve(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        while (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[index]);
        solve(index+1, nums, current, result);

        current.remove(current.size() - 1);

        solve(index+1, nums, current, result);
    }
}
