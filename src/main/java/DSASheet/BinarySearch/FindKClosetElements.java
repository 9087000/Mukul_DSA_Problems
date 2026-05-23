package DSASheet.BinarySearch;

import java.util.*;

public class FindKClosetElements {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 4;
        int x = 3;
        List<Integer> list = findKcloset(nums, k, x);
        System.out.println(list);
    }

    private static List<Integer> findKcloset(int[] nums, int k, int x) {
        //brute
        //1. put all elements into a List
        // 2. Sort by
        // . absolute difference from x
        // . if it is tie, take smallest elements first
        // 3. Take first k elements
        // 4. sort the selected elements in the ascending order
        // 5. return result
        // t.c : o(n logn)
        // s.c : o(n)

//        List<Integer> list = new ArrayList<>();
//
//        for(int num : nums) {
//            list.add(num);
//        }
//
//        list.sort((a,b) -> {
//            int diffA = Math.abs(a - x);
//            int diffB = Math.abs(b - x);
//
//            if(diffA == diffB) {
//                return a - b;
//            }
//
//            return diffA - diffB;
//        });
//
//        List<Integer> collection = new ArrayList<>(list.subList(0, k));
//        Collections.sort(collection);
//        return collection;
        //optimized
        // answer will be contiguos window of fixed size k
        // binary search will be on window start index
        //search
        // left = 0;
        // right = n - k
        //compare
        // x - nums[mid]
        // nums[mid + k] - x

        // if left boundary is futher
        // move right
        // else
        // keep/ move left
        // return nums[left .... left+k -1]
        int left = 0;
        int right = nums.length - k;

        while(left <right) {
            int mid = left + (right - left) / 2;

            if(x - nums[mid]  > nums[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        List<Integer> answer = new ArrayList<>();
        for(int i= left ;i < left + k ; i++) {
            answer.add(nums[i]);
        }
        return answer;
    }
}
