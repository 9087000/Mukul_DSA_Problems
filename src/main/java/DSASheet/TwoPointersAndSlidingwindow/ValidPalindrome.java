package DSASheet.TwoPointersAndSlidingwindow;

import streams.StreamBuilder;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        Boolean valid = validPalindrome(s);
        System.out.println(valid);
    }
    private static boolean validPalindrome(String s) {
//        StringBuilder sb = new StringBuilder();
//        for(int i=0; i<s.length(); i++) {
//            Character ch = s.charAt(i);
//
//            if (Character.isLetterOrDigit(ch)) {
//                sb.append(Character.toLowerCase(ch));
//            }
//        }
//        String clean = sb.toString();
//
//        int left = 0;
//        int right = clean.length() - 1;
//
//        while(left< right) {
//            if (clean.charAt(left) != clean.charAt(right)) {
//                return false;
//            }
//            left++;
//            right--;
//        }
//
//        return true;
        int left = 0;
        int right = s.length() -1;
        while(left < right) {
            Character leftChar = s.charAt(left);
            Character rightChar = s.charAt(right);

            if(!Character.isLetterOrDigit(leftChar)) {
                left++;
            } else if(!Character.isLetterOrDigit(rightChar)) {
                right--;
            } else {
                Character lower = Character.toLowerCase(leftChar);
                Character rightc = Character.toLowerCase(rightChar);
                if(lower != rightc) {
                    return  false;
                }
                left++;
                right--;
            }
        }
        return true;
    }
}
