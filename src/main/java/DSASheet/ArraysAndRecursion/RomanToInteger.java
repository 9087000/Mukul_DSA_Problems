package DSASheet.ArraysAndRecursion;

import java.util.Scanner;
//step - 1 : n <- s.length()
//step - 2 : set total <- 0
//step - 3 : For i from 0 to n - 1
//set curr <- vals(s[i])
//set i + 1 < n , set next <- vals(s[i + 1]) else next <- 0
//if curr < next then total <- total - curr
//else total <- total + curr
//Return total
//step -4
//switch case(c)
// case "I":
//return 1;
//case "V":
//return 5;
//case "X":
//return 10;
//case "L::
//return 50;
//case "C":
//return 100;
//case "D":
//return 500;
//case "M":
//return 1000
//default:
//return 0
public class RomanToInteger {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int st = Integer.parseInt(sc.nextLine().trim());

        while (st-- > 0) {
            String n = sc.nextLine();
            int romantoInt = romanToInt(n);
            System.out.println(romantoInt);
        }
    }

    public static int romanToInt(String s) {
        int n = s.length();
        int total = 0;
        for (int i = 0; i < n; i++) {
            int curr = val(s.charAt(i));
            int next = (i + 1 < n) ? ((val(s.charAt(i + 1)))) : 0;
            if (curr < next) {
                total -= curr;
            } else {
                total += curr;
            }
        }
        return total;
    }

    private static int val(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
