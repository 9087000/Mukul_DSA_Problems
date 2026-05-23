package DSASheet.TwoPointersAndSlidingwindow;

import java.util.ArrayList;
import java.util.List;

public class MovePiecesToObtainAString {
    public static void main(String[] args) {
        String s = "_L__R__R_";
        String t = "L______RR";
        Boolean piece = movePieces(s, t);
        System.out.println(piece);
    }
    private static boolean movePieces(String s, String t) {
        //brute Force
//        StringBuilder startPiece = new StringBuilder();
//        StringBuilder targetPiece = new StringBuilder();
//
//        List<Integer> startPos = new ArrayList<>();
//        List<Integer> targetPos = new ArrayList<>();
//
//        for(int i=0; i<s.length(); i++) {
//            if(s.charAt(i) != '_') {
//                startPiece.append(s.charAt(i));
//                startPos.add(i);
//            }
//        }
//
//        for(int j=0; j<t.length(); j++) {
//            if(t.charAt(j) != '_' ) {
//                targetPiece.append(t.charAt(j));
//                targetPos.add(j);
//            }
//        }
//
//        if(!startPiece.toString().equals(targetPiece.toString())) {
//           return false;
//        }
//
//        for(int i=0; i<startPiece.length(); i++) {
//            char ch = startPiece.charAt(i);
//
//            if(ch == 'L' && startPos.get(i) < targetPos.get(i)) {
//                return false;
//            }
//
//            if(ch == 'R' && startPos.get(i) > targetPos.get(i)) {
//                return false;
//            }
//        }
//
//        return true;
        //Optimized
        int n = s.length();
        int i = 0, j = 0;
        while(i < n || j < n) {
            while(i < n && s.charAt(i) == '_') i++;
            while(j < n && t.charAt(j) == '_') j++;

            if(i == n &&  j == n) return true;
            if(i == n || j == n) return false;

            if(s.charAt(i) != t.charAt(j)) return false;

            if(s.charAt(i) == 'L' && i < j) return  false;
            if(s.charAt(i) == 'R' && i > j) return false;
            i++;
            j++;
        }
        return true;
    }
}
