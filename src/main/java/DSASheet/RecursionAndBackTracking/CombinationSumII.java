package DSASheet.RecursionAndBackTracking;

import java.util.*;

public class CombinationSumII {
    public static void main(String args[]) {
        int[] candidate = {10,1,2,7,6,1,5};
        int target = 8;
        List<List<Integer>> combination = combinationSumII(candidate, target);
        System.out.println(combination);
    }
    private static List<List<Integer>> combinationSumII(int[] candidate, int target) {
        //brute
        // use the sets to remove the duplicates combination
        // sort the combinations
        // Arrays.sort(candidate)
        // result = set<List<Integer>>
        // current = []
        // solve(0, candidate, target, current, result)
        // return new ArrayList<>(result)
        // solve(index, target) i.e solve(int index, int[] candidate, int target, List<Integer> current, Set<List<Integer>> result)
        // if(target == 0) :
        // add the copy of current to result
        // return
        // if(target < 0 || index == candidate.length)
        // return
        // Take
        // add the candidate[index] to current
        // solve(index + 1, candidate, target - candidate[index], current, result)
        // recursion
        // remove the last index
        // skip
        // solve(index + 1, candidate, target, current, result)
        // T.C : o(2^n * k)
        // S.C : o(2^n * k)
//        Arrays.sort(candidate);
//        Set<List<Integer>> result = new HashSet<>();
//        List<Integer> current = new ArrayList<>();
//
//        solve(0, candidate, target, current, result);
//
//        return new ArrayList<>(result);
        //optimized
        // avoid duplicates while generating
        // sort the candidate first
        // result = []
        // current = []
        // solve(0, candidate, target, current, result)
        // return result
        // solve(int index, int[] candidate, int target, List<Integer> current, List<List<Integer>> result) :
        // if(target == 0)
        // add copy of current to result
        // return
        // if(target < 0 || index == candidate.length)
        // return
        // for(int i=index; i<candidate.length. i++) :
        // if(i>index && candidate[index] == candidate[index - 1] ) :
        // continue
        // add the candidate[i] to current
        // solve(i + 1, candidate, target - candidate[i] , current, result)
        // remove the last element
        // T.C : o(2^n * k)
        // S.C : o(n)
        Arrays.sort(candidate);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        solve(0, candidate, target, current, result);

        return result;
    }

    private static void solve(int index, int[] candidate, int target, List<Integer> current, List<List<Integer>> result) {
        //optimized
        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if(target< 0 || index == candidate.length) {
            return;
        }
        for(int i=index; i<candidate.length; i++) {
            if(i>index && candidate[i] == candidate[i - 1]) {
                continue;
            }
            current.add(candidate[i]);
            solve(i+1, candidate, target - candidate[i], current, result);
            current.remove(current.size() - 1);
        }
    }
//    private static void solve(int index, int[] candidate, int target, List<Integer> current, Set<List<Integer>> result) {
//        //brute
//        if(target == 0) {
//            result.add(new ArrayList<>(current));
//            return;
//        }
//        if(target < 0 || index == candidate.length) {
//            return;
//        }
//        current.add(candidate[index]);
//        solve(index + 1, candidate, target - candidate[index], current, result);
//        current.remove(current.size() - 1);
//        solve(index + 1, candidate, target, current, result);
//    }
}
