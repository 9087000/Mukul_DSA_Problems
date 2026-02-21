package Leetcode;

import java.util.Scanner;
//Pattern : Greedy + Two Pointer Logic (1D Distance Comparison) (Approach : Absolute difference approach)
//Step1 : find absolute value using Math.abs(x- z)
//Step2 : find absolute value using Math.abs(y -z)
//Step3 : compares who reaches faster
//step4 : if(value1<value2) return 1;
//step5 : else if(value2<value1) return 2;
//step6: else return 0;
public class FindClosestPerson {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        while(x--> 0) {
            int i = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            int person = findClosetPerson(i, y , z);
            System.out.println(person);
        }
    }

    private static int findClosetPerson(int x, int y, int z) {
        int dist1 = Math.abs(x - z);
        int dist2 = Math.abs(y - z);

        if(dist1 < dist2) return 1;
        else if(dist2 < dist1) return 2;
        else return 0;
    }
}
