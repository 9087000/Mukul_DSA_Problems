package org.example;

import java.util.Scanner;

//pseudocode
//1.Pick the smallest factor a.
//2.Divide n by a -> call this n1
//3.Find another factor b of n1 distinct from a
//4.Compute c = n/ (a * b)
//5. if all three are distinct and >2 -> print YES a b c , else NO

//Mistakes i done
// overwrote n (n=n/a;)  then modified value later. pseudo always keeps originalN intact
//used min(b,i) instead of picking up actual factor.That made b stay 1 in many cases.
//pseudo generally checks n1%j == 0 before assiging b.
//No distinctness />2  guard at the end. pseudo ensuures a,b,c are distinct and >2.
//Code forces
public class ProductOfthreeNumbers {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int sc = scanner.nextInt();

        while(sc-->0) {
            int n = scanner.nextInt();

            int a = -1 , b = -1, c = -1;
            for(int i=2; i*i<=n;i++) {
                if(n % i == 0) {
                    a=i;
                    break;
                }
            }

            if(a==-1) {
                System.out.println("NO");
                continue;
            }

            int n1 = n / a;

            for(int j=a+1; j*j<=n1; j++) {
                if(n1 % j == 0) {
                    b=j;
                    break;
                }
            }

            if(b==-1) {
                System.out.println("NO");
                continue;
            }

            c = n / (a * b);
            if(c>1 && c!=b && c!=a) {
                System.out.println("YES " + a + " " + b + " " + c);
            } else {
                System.out.println("NO");
            }
        }
    }
}
