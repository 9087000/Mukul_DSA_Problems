package DSASheet.Heap;

public class Candy {
    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        int candy = candies(ratings);
        System.out.println(candy);
    }
    private static int candies(int[] ratings) {
        //Optimized
        // Each children has a rating:
        //  Each children has atleast one candy
        // Higher rating than neighbour -> get more candies than neighbours
        // Return minimize total candies
        // it depends on
        // Left neighbour
        // right neighbour
        // it cannot be single pass
        // We pass constraints based on
        // left to right
        // right to left
        // Step 1:
        // candy = 1
        // Mandatory candy for each children is 1
        // step 2 : left to right
        // for i 1 to n - 1 :
        // if rating is greater than left neighbour
        // if rating[i]> rating[i-1]
        // candy = candy[i-1] + 1;
        //
         // step 3 : right to left
        // for i n -  down to 0:
        // if rating is greater than right neighbour
        // if rating[i] > rating[i+1]
        // candy = candy[i+1] + 1;
        // max(previouscandy, new candy)
        // Step : sum all candy
        // for int c with candy array
        // total + = c
        // return total
        // T.C: o(n)
        // S.C: o(n)
        int n = ratings.length;

        int[] candy = new int[n];

        for(int i=0; i<n ;i++) {
            candy[i] = 1;
        }

        for(int i=1; i<n; i++) {
            if(ratings[i] > ratings[i-1]) {
                candy[i] = candy[i-1] + 1;
            }
        }

        for(int i=n-2; i>=0; i--) {
            if(ratings[i]>ratings[i+1]) {
                candy[i] = Math.max(candy[i], candy[i+1] + 1);
            }
        }

        int total = 0;

        for(int c: candy) {
            total+=c;
        }

        return total;
    }
}
