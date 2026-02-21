package DSASheet.RecursionAndBackTracking;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n --> 0) {
            int i = sc.nextInt();
            int f = fibonacci(i);
            System.out.println(f);
        }
    }

    private static int fibonacci(int n) {
        if(n == 0) return 1;
        if(n == 1) return 2;

        int a = 0, b= 1;
        for(int i=2; i<=n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
