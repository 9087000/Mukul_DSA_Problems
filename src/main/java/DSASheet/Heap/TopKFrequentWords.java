package DSASheet.Heap;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] s = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        List<String> string = topKfrequentWords(s, k);
        System.out.println(string);
    }

    private static List<String> topKfrequentWords(String[] s, int k) {
        //brute
        //If it is higher frequency
        // If it is tie, smaller frequency comes first
        // Count the frequency using hashMap
        // put all unique wors into list
        // sort the list by :
        // frequency descending
        // if it is tie , word ascending
        // return the first k words
        // T.C: o(n log n)
        // S.c: o(k)
//        Map<String, Integer> map = new HashMap<>();
//
//        for(String word : s) {
//            map.put(word, map.getOrDefault(word, 0) + 1);
//        }
//
//        List<String> list = new ArrayList<>(map.keySet());
//
//        Collections.sort(list, (a,b) -> {
//            if(map.get(b).equals(map.get(a))) {
//               return a.compareTo(b);
//            }
//
//            return map.get(b) - map.get(a);
//        });
//
//        return list.subList(0, k);
        //optimized
        //Use min heap of size k
        // it beacomes "worst" when the heap exceeds size k
        // if it is lower frequency
        // if it is tie, the larger element comes first
        // if it is higher frequency
        // if it is tie, the smaller element comes first
        // count the frequency using hashMap
        // Create min heap and compare it using custom comparator
        // For each word in heap:
        // add the word
        // when heap size exceeds k
        // remove the top k words
        // Heap now contains top k words
        // Poll all words from heap
        // reverse result
        // T.C: o(log k)
        // s.c: o(k)
        Map<String, Integer> freq = new HashMap<>();

        for(String word : s) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a,b) -> {
            if(freq.get(a).equals(freq.get(b))) {
                return b.compareTo(a);
            }
            return freq.get(a) - freq.get(b);
        });

        for(String word: freq.keySet()) {
            pq.offer(word);
            if(pq.size()>k) {
                pq.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while(!pq.isEmpty()) {
            result.add(pq.poll());
        }

        Collections.reverse(result);
        return result;

    }
}
