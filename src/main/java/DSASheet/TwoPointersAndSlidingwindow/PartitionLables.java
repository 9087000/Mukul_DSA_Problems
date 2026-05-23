package DSASheet.TwoPointersAndSlidingwindow;

import java.util.ArrayList;
import java.util.List;

public class PartitionLables {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> partition = partitionLabel(s);
        System.out.println(partition);
    }

    //    private static List<Integer> partitionLabel(String s) {
//        List<Integer> part = new ArrayList<>();
//        int start = 0;
//        int n = s.length();
//        while(start < n) {
//            for (int end = start; end < n; end++) {
//                 if(isValid(s, start, end )) {
//                     part.add(end - start + 1);
//                     start = end + 1;
//                     break;
//                 }
//            }
//        }
//        return part;
//    }
//    private static boolean isValid(String s, int start, int end) {
//        for(int i=start; i<=end; i++) {
//            char ch = s.charAt(i);
//            for(int j=end+1; j<s.length(); j++) {
//                if(s.charAt(j) == ch) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
    private static List<Integer> partitionLabel(String s) {
        int[] last = new int[26];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length() ; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length() ; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}