package DSASheet.TwoPointersAndSlidingwindow;

import com.sun.source.tree.BreakTree;

import java.util.*;

public class fourSum {
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> list = fourSums(nums, target);
        System.out.println(list);
    }

    private static List<List<Integer>> fourSums(int[] nums, int target) {
//        Set<List<Integer>> set = new HashSet<>();
//        for(int i=0; i<nums.length; i++) {
//            for(int j=i+1; j<nums.length; j++) {
//                for(int k=j+1; k<nums.length; k++) {
//                    for(int p=k+1; p<nums.length; p++) {
//                        int sum = nums[i] + nums[j] + nums[k] + nums[p];
//
//                        if(sum == target) {
//                            List<Integer> li = Arrays.asList(nums[i], nums[j], nums[k], nums[p]);
//                            Collections.sort(li);
//                            set.add(li);
//                        }
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(set);
//        Arrays.sort(nums);
//        Set<List<Integer>> set = new HashSet<>();
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                int left = j + 1;
//                int right = nums.length - 1;
//
//                while (left < right) {
//                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
//
//                    if (sum == target) {
//                        set.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
//                        left++;
//                        right--;
//                    } else if (sum < target) {
//                        left++;
//                    } else {
//                        right--;
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(set);
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length - 3; i++) {
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j=i+1; j<nums.length - 2; j++) {
                if(j>i+1 && nums[j] == nums[j-1]) continue;
                int left = j + 1;
                int right = nums.length - 1;

                while(left< right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if(sum == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                        while(left<right && nums[left]== nums[left - 1]) {
                            left++;
                        }
                        while(left<right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if(sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return list;
    }
}
