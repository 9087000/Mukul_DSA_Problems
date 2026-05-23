package DSASheet.Heap;

import java.util.*;

public class TaskScheduler {
    public static void main(String[] args) {
        char[] ch = {'A','A', 'A', 'B', 'B', 'B'};
        int n = 2;
        int task = taskScheduler(ch , n);
        System.out.println(task);
    }

    private static int taskScheduler(char[] ch, int n) {
        //brute
//        int[] freq = new int[26];
//
//        for(char c : ch) {
//            freq[c - 'A']++;
//        }
//
//        int maxFreq = 0;
//        for(int f : freq) {
//            maxFreq = Math.max(maxFreq, f);
//        }
//
//        int maxCount = 0;
//        for(int f : freq) {
//            if(f == maxFreq) {
//                maxCount++;
//            }
//        }
//
//        int part = (maxFreq - 1) * (n + 1) + maxCount;
//
//        return Math.max(ch.length, part);
        //optimized
        int[] freq = new int[26];

        for(char c: ch) {
            freq[c - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);

        for(int f : freq) {
            if(f>0) {
                maxHeap.offer(f);
            }
        }

        int time  =0;
        while (!maxHeap.isEmpty()) {
            int cycle = n + 1;
            List<Integer> list = new ArrayList<>();
            int taskDone = 0;

            while (cycle>0 && !maxHeap.isEmpty()) {
                int curr = maxHeap.poll();

                if(curr - 1 > 0) {
                    list.add(curr-1);
                }

                taskDone++;
                cycle--;
            }

            for(int t:list) {
                maxHeap.offer(t);
            }

            if(maxHeap.isEmpty()) {
                time += taskDone;
            } else {
                time += (n + 1);
            }
        }

        return time;
    }
}
