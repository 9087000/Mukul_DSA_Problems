package DSASheet.Heap;

import java.util.*;

public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones = {1};
        int stone = lastRemainingStone(stones);
        System.out.println(stone);
    }

    private static int lastRemainingStone(int[] stones) {
        //brute
        //Create arraylist
        //put all elements into list
        // while list.size() > 1
        // Take the first largest y : last element
        // Take the second Largest x : new last element
        // if(y != x)
        // list.add(y-x)
        // if list.isEmpty() : return 0;
        // else return list.get(0)
        // T.c: o(n2 log n)
        // S.c: o(n)
//        List<Integer> list = new ArrayList<>();
//
//        for(int stone: stones) {
//            list.add(stone);
//        }
//
//        while(list.size() > 1) {
//            Collections.sort(list);
//
//            int y = list.remove(list.size() - 1);
//            int x = list.remove(list.size() - 1);
//
//            if(y != x) {
//                list.add(y - x);
//            }
//        }
//
//        return list.isEmpty() ? 0 : list.get(0);

        //optimized
        // Create a maxHeap
        // put all stones into maxHeap
        // while(maxHeap.size() > 1)
        // Take first largest Y : maxHeap.poll()
        // Take second Largest x : maxHeap.poll()
        // if(y != x)
        // return maxHeap.offer(y - x)
        // if maxHeap.isEmpty(): 0
        // else maxHeap.peek();
        //T.c: o(n log n)
        // S.c : o(n)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        for(int stone: stones) {
            maxHeap.offer(stone);
        }
        while(maxHeap.size() > 1) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();

            if(y != x) {
                maxHeap.offer(y - x);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
