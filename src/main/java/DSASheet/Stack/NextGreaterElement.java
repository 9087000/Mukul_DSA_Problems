package DSASheet.Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String args[]) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        int[] nextGreater = nextgreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(nextGreater));
    }

    private static int[] nextgreaterElement(int[] nums1, int[] nums2) {
        //brute
//        int[] result = new int[nums1.length];
//
//        for(int i=0; i<nums1.length; i++) {
//            int target = nums1[i];
//            int index = -1;
//
//            for(int j=0; j<nums2.length; j++) {
//                if(nums2[j] == target) {
//                    index = j;
//                    break;
//                }
//            }
//
//            int nextGreater = -1;
//            for(int j= index+1 ; j<nums2.length; j++) {
//                if(nums2[j] > target) {
//                    nextGreater = nums2[j];
//                    break;
//                }
//            }
//
//            result[i] = nextGreater;
//        }
//        return result;
      //optimized
      Map<Integer, Integer> map = new HashMap<>();
      Stack<Integer> stack = new Stack<>();

      for(int num: nums2) {
          if(!stack.isEmpty() && num > stack.peek()) {
              map.put(stack.pop(), num);
          }
          stack.push(num);
      }

      while (!stack.isEmpty()) {
          map.put(stack.pop(), -1);
      }

      int[] result = new int[nums1.length];
      for(int i=0; i<nums1.length; i++) {
          result[i] = map.get(nums1[i]);
      }
      return result;
     }
}
