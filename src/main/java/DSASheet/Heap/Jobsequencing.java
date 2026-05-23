package DSASheet.Heap;

import java.util.ArrayList;
import java.util.Arrays;

public class Jobsequencing {
    public static void main(String[] args) {
        int[] deadline = {4,1,1,1};
        int[] profit = {20,10,40,30};
        ArrayList<Integer> job = jobSequencing(deadline, profit);
        System.out.println(job);
    }
    private static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        //Optimized
        // Each job has
        // deadline
        // profit
        // Each job takes 1 unit of time
        // Goal:
        // maximize profit
        // return [noofJobDone, totalprofit]
        // Do high priority job first
        // Try to place the each jobs on or before deadline
        // If we place job too early, then another job with earlier deadline
        // So we try to place job as late as possible
        // Greedy
        // for each deadline it is down to 0
        // so for larger n it will result in TLE
        // DSU
        // DSU helps to find
        // Latest avaliable free slot <= deadline
        // Instead of scanning backward one by one
        // parent[x]  latest available slot on or before x
        //  parent[i] = i
        // means free slot at start
        //  find(x) avaliable free slot <= x
        //  pseducode
        // function(deadline, profit):
        // int n = deadline.length
        // int[] job
        // int maxDeadline
        // for i to n - 1
        // jobs.add(deadline[i], profit[i])
        // max(maxdeadline, deadline[i])
        // sort it by profit descending
        // parent array intialize of maxDeadline + 1;
        // for i to n - 1
        // parent[i] = i
        // int count
        // int totalProfit
        // for job array with jobs
        // int d = job.deadline
        // int p = job.profit
        // int availableslot = find(parent,d)
        // if(availableslot> 0)
        // count++
        // totalProfit+=p
        // parent[availableslot] = find(parent, avaliableslot - 1)
        // return[count, totalProfilt]
        // function find(parent, x) :
        // if (parent[x] == x) return x
        // return parent[x] = find(parent, parent[x])
        // T.C: o(n log n)
        // S.C: o(D)
        int n = deadline.length;

        int[][] jobs = new int[n][2];
        int maxDeadline = 0;
        for(int i=0; i<n; i++) {
            jobs[i][0] = deadline[i];
            jobs[i][1] = profit[i];
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }

        Arrays.sort(jobs, (a,b)-> b[1] - a[1]);
        int[] parent = new int[maxDeadline + 1];

        for(int i=0; i<=maxDeadline; i++) {
            parent[i] = i;
        }

        int count = 0;
        int totalProfit = 0;

        for(int[] job: jobs) {
            int d = job[0];
            int p = job[1];

            int avalibleSlot = find(parent,d);

            if(avalibleSlot>0) {
                count++;
                totalProfit+=p;
                parent[avalibleSlot] = find(parent, avalibleSlot - 1);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(count);
        ans.add(totalProfit);
        return ans;
    }

    private static int find(int[] parent, int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent, parent[x]);
    }
}
