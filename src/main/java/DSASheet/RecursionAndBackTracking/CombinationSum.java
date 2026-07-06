package DSASheet.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String args[]) {
        int[] candidate = {2,3,6,7};
        int target = 7;
        List<List<Integer>> combination = combinationSum(candidate, target);
        System.out.println(combination);
    }
    private static List<List<Integer>> combinationSum(int[] candidate, int target) {
        //brute
        // for Every number
        // we have two choices
        // take number
        // skip number
        // result create a list
        // current create a list
        // solve(index, target( i.e solve(index, candidate, target, current, result)
        // return list
        // solve(index, candidate, target, current, result):
        //  if(target == 0)
        // add the current to result
        // return
        // if(taget < 0 || index == candidate.length) :
        // return stop recursion
        // take
        // add the candidate[index] to current
        // use same index since we can recurse again
        // solve(index, candidate, target - candidate[i] , current, result)
        // remove last from current
        //  skip
        // solve(index + 1, candidate, target, current, result)
        // T.C : o(2^taget)
        // S.C : o(target)

//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> current = new ArrayList<>();
//
//        solve(0, candidate, target, current, result);
//
//        return result;
        //optimized
        // instead of checking using take/ skip
        // we will try all posibilites using for loop
        // create list result
        // crete list current
        // solve (index, target) i.e solve(index, candidate, target, current, result)
        // return result
        // solve(index, target) :
        // if(target == 0) :
        // add the current list to result
        // return
        // if(target < 0 || index = candidate.length):
        // skip recursion
        // return
        // for(int i =index; i<candidate.length; i++) :
        // add the current with candidate[i]
        // use same index where same recusion can appear again
        // solve(index, candidate, target - candidate[i] , current, result)
        // remove the last number from current
        // T.C : o(2^target)
        // S.C : o(target)
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();


        solve(0, candidate, target, current, result);

        return result;

    }
    private static void solve(int index, int[] candidate, int target, List<Integer> current, List<List<Integer>> result) {
        //optimized
        if(target==0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if(target<0 || index == candidate.length) {
            return;
        }

        for(int i=index; i<candidate.length; i++) {
            current.add(candidate[i]);
            solve(i, candidate, target-candidate[i], current, result);
            current.remove(current.size() - 1);
        }
        //brute
        //        if(target == 0) {
//            result.add(new ArrayList<>(current));
//            return;
//        }
//        if(target < 0 || index == candidate.length) {
//            return;
//        }
//        current.add(candidate[index]);
//        solve(index, candidate, target - candidate[index], current, result);
//        current.remove(current.size() - 1);
//        solve(index + 1, candidate, target, current, result);
    }
}
