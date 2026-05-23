package DSASheet.TwoPointersAndSlidingwindow;

import java.util.*;

public class RepeatedDNASequence {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> dna = repatedDNAseq(s);
        System.out.println(dna);
    }

    private static List<String> repatedDNAseq(String s) {
//        Set<String> seen = new HashSet<>();
//        Set<String> repeated = new HashSet<>();
//        for(int i=0; i<=s.length()-10; i++) {
//               String sub = s.substring(i , i + 10);
//               if(seen.contains(sub)) {
//                   repeated.add(sub);
//               } else {
//                  seen.add(sub);
//               }
//        }
//        return new ArrayList<>(repeated);
        //more optimized approach of bit manipulation
        List<String> result = new ArrayList<>();
        if(s.length()<10) return result;

        Map<Character , Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        int hash = 0;
        int mask = (1 << 20) - 1;

        Set<Integer> seen=  new HashSet<>();
        Set<Integer> rep = new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            hash = (hash<<2) | map.get(s.charAt(i));
            hash = mask & hash;
            if(i>=9) {
                if(seen.contains(hash)) {
                    if(rep.add(hash)) {
                         result.add(s.substring(i-9, i+1));
                    }
                } else {
                    seen.add(hash);
                }
            }
        }
        return result;
    }
}
