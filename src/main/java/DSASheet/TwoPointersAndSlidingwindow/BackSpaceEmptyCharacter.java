package DSASheet.TwoPointersAndSlidingwindow;

public class BackSpaceEmptyCharacter {
    public static void main(String[] args) {
         String s = "ab#c";
         String t = "ad#c";
         Boolean empty = backSpace(s,t);
         System.out.println(empty);
    }
    private static boolean backSpace(String s, String t) {
//        return build(s).equals(build(t));
        int left = s.length() - 1;
        int right = t.length() - 1;
        int skipS = 0;
        int skipT = 0;

        while(left >= 0 || right >= 0) {
            while(left>=0) {
                if(s.charAt(left) == '#') {
                    skipS++;
                    left--;
                } else if(skipS > 0) {
                    skipS--;
                    left--;
                } else {
                    break;
                }
            }

            while(right>=0) {
                if(s.charAt(right) == '#') {
                    skipT++;
                    right--;
                } else if(skipT > 0) {
                    skipT--;
                    right--;
                } else {
                    break;
                }
            }



            if(left>=0 && right >= 0) {
                if(s.charAt(left) != t.charAt(right)) return false;
            }
            else {
                if(left>= 0 || right>=0) return  false;
            }
            left--;
            right--;
        }
        
        return true;

    }

//    private static String build(String s) {
//        StringBuilder sb = new StringBuilder();
//        for(char c : s.toCharArray()) {
//            if(c == '#') {
//                if(sb.length() > 0 ) {
//                sb.deleteCharAt(sb.length() - 1);
//                }
//            } else {
//                sb.append(c);
//            }
//        }
//        return sb.toString();
//    }
}
