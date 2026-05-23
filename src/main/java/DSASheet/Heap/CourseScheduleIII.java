package DSASheet.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleIII {
    public static void main(String[] args) {
        int[][] courses = {{100,200},{200,1300},{1000,1250},{2000,3200}};
        int course = courserSchedule(courses);
        System.out.println(course);
    }
    private static int courserSchedule(int[][] courses) {
        //Optimized
        // Each course
        // duration = how many days it takes
        // last day = deadline to finish course
        // You need to return the maximum number of courses
        // sort by deadline
        // Try taking every course possible
        // if time exceeds deadline remove the largest one so far
        // By removing largest one it gives back time so we can take more courses as possible
        // Step 1 : sort by deadline last days ascending
        // Heap store the duration of selected courses
        // maxHeap = selected courses duration
        // time = total number of selected courses duration
        // Courses with earlier deadline should be considered first
        // The dealy of early deadly courses ,we miss them
        // if the time exceeds deadline we remove one of selected courses
        // To return maximum courses we should remove the largest courses so that we can return maximum possible courses
        // MAx heap gives longest duration  quickly
        // sort by deadline last day ascending
        // time = 0
        // maxHeap = empty
        // for i to n - 1
        // duration = courses[0]
        // deadline = courses[1]
        // time+=duration
        // add the heap to duration
        // if time > deadline
        // longest = heap.poll()
        // time-=longest
        // return heap.size()
        //T.C: o(n log n)
        // S.C: o(n)
        int n = courses.length;
        Arrays.sort(courses,(a,b)->a[1] - b[1]);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a);
        int time = 0;

        for(int i=0; i<n; i++) {
            int duration = courses[i][0];
            int deadline = courses[i][1];
            time+=duration;
            maxHeap.add(duration);

            if(time>deadline) {
                int longest = maxHeap.poll();
                time-=longest;
            }
        }

        return maxHeap.size();
    }
}
