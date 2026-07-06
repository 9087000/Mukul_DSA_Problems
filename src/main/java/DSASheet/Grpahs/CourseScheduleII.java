package DSASheet.Grpahs;

import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args) {
        int numCourse = 2;
        int[][] prerequesities = {{1,0}};
        int[] schedule = courseScheduleII(numCourse, prerequesities);
        System.out.println(Arrays.toString(schedule));
    }
    //Optimized
    // Create a adjacent list graph
    // for course from 0 to numCourse
    // graph add with arrayList new
    // For every prerequesite
    // pre-> course
    // initialize queue
    // create indegree[] with size of numCourses
    // Loop through all course with indegree == 0 add all courses to queue
    //  initialize answer with size of numCourse
    // initialize index = 0
    // while queue isEmpty not then
    // poll the queue i.e current
    // increment index of answer that is current
    // for the neighbour  that is graph with current
    // decrement the indegree[neighbour]
    // if the indegree == 0
    // queue offer with neighbour
    // if the index == numCourse
    // return answer
    // else
    // return empty array i.e return new int[0]
    // T.C : o(V + E)
    // S.C : o(V + E)
    // List<List<Integer>> graph = new ArrayList<>()
    // for course from 0 to numCourse
    // graph.add(new ArrayList<>())
    // int[] indegree = new int[numcourse]
    // for int[] pre to prerequisities
    // course = pre[0]
    // prei = pre[1]
    // graph.get(prei).add(course)
    // indegree[course]++
    // Queue<Integer> queue = new LinkedList<>()
    // for course from 0 to newCourses
    // if indegree == 0
    // queue.offer(course)
    // int[] answer = new int[newCourse]
    // int index = 0
    // while(!queue.isEmpty)
    // int current = queue.poll()
    // answer[index++] = current
    // for int neighbour : graph.get(current)) :
    // indegree[neighbour]--
    // if(indegree[neighbour] == 0)
    // queue.offer(neighbour)
    // if index == numCourse
    // return answer
    // else
    // return new int[0]
    private static int[] courseScheduleII(int numCourse, int[][] prerequesitiies) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int course=0; course<numCourse; course++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourse];
        for(int[] pre: prerequesitiies) {
            int course = pre[0];
            int prei = pre[1];

            graph.get(prei).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int course=0; course<numCourse; course++) {
            if(inDegree[course] == 0) {
                queue.offer(course);
            }
        }
        int[] answer = new int[numCourse];
        int index = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            answer[index++] = current;

            for(int neighbour: graph.get(current)) {
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        if(index == numCourse) {
            return answer;
        } else {
            return new int[0];
        }
    }
    //brute
    // create a adjacent list graph
    // for course 0 to numCourses
    // graph add the new ArrayList
    // For every prerequesities we add edge
    // pre -> course
    // create
    // visited[]
    // pathvisited[]
    // stack
    // Loop through all courses
    // if the course is not visited
    // run the dfs on the course
    // in the dfs
    // mark the visited[course] = true
    // pathvisited[course] = true
    // for int neighbour from graph.get(course):
    // if the dfs is not visited
    // run the dfs on neighbour
    // return true
    // if the cycle exist , return true i.e pathvisited[neighbour] = true
    // mark the pathvisted[course] = false
    // push the stack to course
    // if the cycle exists return empty array
    // intialize answer with size of numCourses
    // intialize index with 0
    // while queue isEmpty if it is not empty
    // answer[index++] = stack.pop
    // return answer
    // T.C : o(V + E)
    // S.C : o(V + E)
    // List<List<Integer>> graph = new ArrayList<>()
    // for course from 0 to numCourse
    // graph.add(new ArrayList<>())
    // boolean[] visited with size of numCourse
    // boolean[] pathvisited with size of numCourse
    // stack<integer> stack = new Stack<>()
    // for course from 0 to numCourse
    // if the !visited[course]
    // if (dfs(course, graph, visited, pathvisited, stack)
    // return empty array i.e return new int[0]
    // int[] answer = new int[newCourse]
    // index = 0
    // while(!stack.isEmpty())
    // answer[index++] = stack.pop
    // return answer
    // dfs(int course, List<List<Integer>> graph, boolean[] visited, boolean[] pathvisited, Stack<Integer> stack) :
    // visited[course] = true
    // pathvisited[course] = true
    // for neighbour to graph.get(course)
    // if !visited[neighbour] :
    // if the dfs(course, graph, visited, pathvisited, stack)
    // return true
    // else if pathvisited[neighbour]
    // return true
    // pathvisited[course] = false
    // stack.push(course)
    // return false
//    private static int[] courseScheduleII(int numCourse, int[][] prerequesities) {
//        List<List<Integer>> graph = new ArrayList<>();
//
//        for(int course=0; course<numCourse; course++) {
//            graph.add(new ArrayList<>());
//        }
//        for(int[] pre: prerequesities) {
//            int course = pre[0];
//            int preq = pre[1];
//
//            graph.get(preq).add(course);
//        }
//        boolean[] visited = new boolean[numCourse];
//        boolean[] pathVisited = new boolean[numCourse];
//        Stack<Integer> stack = new Stack<>();
//        for(int course=0; course<numCourse; course++) {
//            if(!visited[course]) {
//                if(dfs(course, graph, visited, pathVisited, stack)) {
//                    return new int[0];
//                }
//            }
//        }
//
//        int[] answer = new int[numCourse];
//
//        int index = 0;
//
//        while(!stack.isEmpty()) {
//            answer[index++] = stack.pop();
//        }
//
//        return answer;
//    }
//    private static boolean dfs(int course, List<List<Integer>> graph , boolean[] visited, boolean[] pathvisited, Stack<Integer> stack) {
//        visited[course] = true;
//        pathvisited[course] = true;
//        for(int neighbour: graph.get(course)) {
//            if(!visited[neighbour]) {
//                 if(dfs(neighbour, graph, visited, pathvisited, stack)) {
//                     return true;
//                 }
//            }  else if(pathvisited[neighbour]) {
//                return true;
//            }
//        }
//        pathvisited[course] = false;
//        stack.push(course);
//        return false;
//    }
}
