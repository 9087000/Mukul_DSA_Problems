package DSASheet.Heap;

import java.util.*;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] kfrequent = topKfrequent(nums, k);
        System.out.println(Arrays.toString(kfrequent));
    }

    private static int[] topKfrequent(int[] nums, int k) {
        //brute
        // 1. Count frequency of numbers
        // 2. convert to List
        // 3. list sort by ascending order
        // 4. Pick first k elements
        // t.c : o(n log n)
        // s.c : o(n)
//        Map<Integer, Integer> map = new HashMap<>();
//
//        for(int num : nums) {
//            map.put(num, map.getOrDefault(num , 0 ) + 1);
//        }
//
//        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
//
//        list.sort((a,b) -> b.getValue() - a.getValue());
//
//        int[] result = new int[k];
//        for(int i=0; i<k; i++) {
//            result[i] = list.get(i).getKey();
//        }
//        return result;
        //optimized
        //1. count frequency of number
        // 2. Create Min heap
        // 3. Maintain min heap of size k
        // 4. extract result
        //t.c : o(n log k)
        // s.c : o(k)
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));

        for(int num : map.keySet()) {
            queue.offer(num);

            if(queue.size() > k) {
                queue.poll();
            }
        }

        int[] result = new int[k];

        for(int i=k-1; i>=0 ; i--) {
                result[i] = queue.poll();
        }

        return result;
    }
}
