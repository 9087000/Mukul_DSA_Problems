package DSASheet.Heap;

import java.util.*;

public class DistantBarcodes {
    public static void main(String[] args) {
        int[] barcodes = {1,1,1,2,2,2};
        int[] bar = distantBarcodes(barcodes);
        System.out.println(Arrays.toString(bar));
    }

    private static int[] distantBarcodes(int[] barcodes) {

        //optimized
        // Core idea: Max heap + greedy
        // Because we want to place most frequent value at first, but we should not place same value next to itself. So we choose top two frequent values at time
        // Count frequencies of number
        // put {number, frequency} into maxHeap
        // while heap.size() > 1
        // poll first frequent value
        // poll second frequent value
        // put both into result
        // decrease frequencies
        // if still it is > 0 -> push back into heap
        // if still one element is there add to result
        // if we choose only one  frequent value repeatadely we may haveadjacent duplicate number so we choose first , second safely to get the most frequnt values
        // T.C: o(n log n)
        // S.C : o(n)
        Map<Integer, Integer> map = new HashMap<>();

        for(int bar: barcodes) {
            map.put(bar, map.getOrDefault(bar, 0) + 1);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> {
            if(b[1] == a[1]) return b[0] - a[0];
            return b[1] - a[1];
        });

        for(int key: map.keySet()) {
            maxHeap.offer(new int[]{key, map.get(key)});
        }

        int[] result = new int[barcodes.length];
        int index = 0;

        while(maxHeap.size() > 1) {
            int[] first = maxHeap.poll();
            int[] second = maxHeap.poll();

            result[index++] = first[0];
            result[index++] = second[0];

            first[1]--;
            second[1]--;

            if(first[1] > 0) {
                maxHeap.offer(first);
            }
            if(second[1] > 0) {
                maxHeap.offer(second);
            }
        }

        if(!maxHeap.isEmpty()) {
            result[index++] = maxHeap.poll()[0];
        }
        return result;
    }
}
