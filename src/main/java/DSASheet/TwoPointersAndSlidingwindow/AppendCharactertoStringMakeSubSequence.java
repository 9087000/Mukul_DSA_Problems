package DSASheet.TwoPointersAndSlidingwindow;

public class AppendCharactertoStringMakeSubSequence {
     public static void main(String[] args) {
         String s = "Coding";
         String t = "Coaching";
         int characters = appendCharacters(s,t);
         System.out.println(characters);
     }
     private static int appendCharacters(String s, String t) {
//         int count = 0;
//         for(int i=0; i<s.length(); i++) {
//                 if(count < t.length() && s.charAt(i) == t.charAt(count)) {
//                     count++;
//                 }
//         }
//         return t.length()-count;
         int left = 0;
         int right = 0;

         while(left < s.length() && right < s.length()) {
             if(s.charAt(left) == t.charAt(right)) {
                 right++;
             }
             left++;
         }
         return t.length() - right;
     }
}
