package DSASheet.RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationOfPhone {
    public static void main(String[] args) {
        String digits = "23";
        List<String> letter = letterCombinationOfPhone(digits);
        System.out.println(letter);
    }
    //optimized
    // Use StringBuilder instrad of creating a new string everyTime
    // append
    // recurse
    // deleteLast char
    // create a empty list
    // result = []
    // check digits.length() == 0
    // return result
    // Initialize String builder
    // StringBuilder sb = new StringBuilder()
    // solve(0, digits, sb, result)
    // return result
    // solve(index,digits, sb, result):
    // if index == digits.length()
    // add the result with sb.toString() i.e result.add(sb.toString())
    // return
    //  get the current digit
    // char digit = digits.charAt(index)
    // String[] keyPad = {
    // "", //0
    // "", //1
    // "abc" , //2
    // "def", //3
    // "ghi",  //4
    // "jkl", //5
    // "mno", //6
    // "pqrs", //7
    // "tuv", //8
    // "wxyz" //9
    // };
    // get the mapped letters from current digits
    // String letter = keyPad[digit - '0']
    // for char ch : letters.toCharArray() :
    // append ch
    // sb.append(ch)
    // recurse
    // solve(index + 1, digits, sb, result)
    // remove the last char
    // sb.deleteCharAt(sb.length() - 1)
    // T.C : o(4^n * n)
    // S.C : o(n)
    private static List<String> letterCombinationOfPhone(String digits) {
        List<String> result = new ArrayList<>();

        if(digits.length() == 0) {
            return result;
        }

        StringBuilder sb = new StringBuilder();

        solve(0, digits, sb, result);

        return result;
    }

    private static void solve(int index, String digits, StringBuilder sb, List<String> result) {
        if(index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        char digit = digits.charAt(index);

        String[] keypad = {
                "",  //0
                "",  //1
                "abc", //2
                "def", //3
                "ghi", //4
                "jkl", //5
                "mno", //6
                "pqrs", //7
                "tuv", //8
                "wxyz", //9

        };
        String letters = keypad[digit - '0'];

        for(char ch : letters.toCharArray()) {
            sb.append(ch);

            solve(index + 1, digits, sb, result);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
//    //brute
      // use normal recursion with current + ch
      // we chpose one letter from each digit
      // result = []
      // digit.length() == 0
      // return result
      // create or choose solve(index, current) i.e solve(0, " ", digits, result)
      // return result
      // solve(index, current, digits, result) :
      // if index == digits.length()
      // add the current to result
      // return
      // get current digit
      // char digit = digits.charAt(index)
      // String[] keypad =  {
      // "", //0
      // "", //1
      // "abc", //2
      // "def", //3
      // "ghi" , //4
      // "jkl", //5
      // "mno", //6
      // "pqrs", //7
      // "tuv", //8
      // "wxyz" //9
      // };
      // Get the mapped letters from current digit
      // String letters = keyPad[digits - '0']
      // for each char ch : letters.toCharArray() :
      // add the current + ch to every digit
      // recurse solve(index+1)
      // solve(index + 1, current+ch, digits, result)
      // T.C : o(4^n * n)
      // S.C : o(n)
 //    private static List<String> letterCombinationOfPhone(String digits) {
//        List<String> result = new ArrayList<>();
//
//        if(digits.length() == 0) {
//            return  result;
//        }
//
//        solve(0, "", digits, result);
//        return result;
//    }
//
//    private static void solve(int index, String current, String digits, List<String> result) {
//        if (index == digits.length()) {
//            result.add(current);
//            return;
//        }
//
//        char digit = digits.charAt(index);
//        String[] keypad = {
//                "", // 0
//                "", //1
//                "abc", //2
//                "def", //3
//                "ghi", //4
//                "jkl", //5
//                "mno", //6
//                "pqrs", //7
//                "tuv", //8
//                "wxyz" //;
//        };
//        String letters = keypad[digit - '0'];
//
//        for(char ch : letters.toCharArray()) {
//            solve(index + 1, current + ch, digits, result);
//        }
//    }
}
