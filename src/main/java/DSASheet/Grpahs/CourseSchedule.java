package DSASheet.Grpahs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 2;
        int[][] preRequsities = {{1,0}};
        boolean scedhule =  courseSchedule(numCourses, preRequsities);
        System.out.println(scedhule);
    }
    //optimzied with kahn
    // Create a adjacent list graph
    // create a new indegree[] with size of numCourses
    // For every prerequesite
    // pre->course
    // indegree[course]++
    // create a queue
    // loop through course add all course with indegree[course] == 0 into queue
    // initialize completed = 0
    // while queue is not empty
    // poll the queue i.e current
    // increment completed completed++
    // for int neighbour: graph.get(current))
    // indegree[neighbour] --
    // if the indegree[neighbour] == 0
    // add the neighbour to queue
    // if
    // completed == numCourses
    // return true
    // else return false
    // T.C; o(V + E)
    // S.C : o(V + E)
    // List<List<Integer>> graph = new ArrayList<>();
    // for int course from 0 to numCourses
    // graph.add(new ArrayList<>())
    // int[] indegree = new int[numCourses]
    // for int[] pre: prerequesities
    // course = pre[0]
    // prei = pre[1]
    // graph.get(prei).add(course)
    // indegree[course]++
    // Queue<integer> queue = new LinkedList<>()
    // for int course from 0 to numCourse
    // if indegree[course] == 0
    // queue.offer(course)
    // int completed = 0
    // while(!queue.isEmpty())
    // int current = queue.poll()
    // completed++
    // for(int neighbour: graph.get(current))
    // indegree[neighbpur]--
    // if(indegree[neighbour] == 0)
    // queue.offer(neighbour)
    // return completed == numCourses
    private static boolean courseSchedule (int numCourse, int[][] preRequsities) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int course=0; course<numCourse; course++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourse];

        for(int[] prerequisite: preRequsities) {
            int course = prerequisite[0];
            int pre = prerequisite[1];

            graph.get(pre).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int course=0 ; course<numCourse; course++) {
            if(indegree[course] == 0) {
                queue.offer(course);
            }
        }

        int completed = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            completed++;

            for(int neighbour : graph.get(current)) {
                indegree[neighbour]--;
               if(indegree[neighbour] == 0) {
                   queue.offer(neighbour);
               }
            }

        }
        return completed == numCourse;
    }
    //brute
    // Create adjacent list graph
    // Loop through all courses
    // add graph with new list
    // For every prerequesite pre[course, pre] add edge
    // pre -> course
    // create
    // visited[] with size of course
    // pathVisited[] with size of course
    // loop through all courses
    // if the course is not visited
    // then run dfs
    // dfs(course, graph, visited, pathvisited)
    // in dfs, mark
    // dfs(course, graph, visited, pathvisited)
    // visited[course] = true
    // pathvisited[course] = true
    // for neighbour starting to graph.get(course)
    // if the neighbour is not visited
    // then dfs on neighbour and return true
    // dfs(neighbour, graph, visited, pathvisited)
    // return true
    // else if pathvisited[neghbour] to true
    // return true
    // at last mark pathvisited[course] to false
    // if cycle found return false
    // if no cycel found return true
    // T.C : o(V + E)
    // S.C : o(V + E)
    // List<List<Integer>> graph = new ArrayList<>()
    // for course from 0 to numcourses
    // graph.add(new ArrayList<>());
    // for int[] pre : prerequsities
    // int course = pre[0]
    // int prei = pre[1]
    // graph.get(prei).add(course)
    // boolean[] visited = new boolean[numCourses]
    // boolean[] pathvisited = new boolean[numCourses]
    // for course from 0 to numCourses
    // if (!visited(course))
    // if (dfs(course, graph, visited, pathvisited))
    // return false
    // return true
    // dfs(course, graph, visited, pathvisited)
    // visited[course] = true
    // pathvisited[course] = true
    // for int neighbour : grpah.get(coruse) :
    // if (!visited(neighbour))
    // if(dfs(neighbour, graph, visited, pathvisited)
    // return true
    // else if (pathvisited[neighbour]))
    // return true
    // pathvisited[course] = false
    // return false
 //    private static boolean courseSchedule(int numCourse, int[][] prequsities) {
//       List<List<Integer>> graph = new ArrayList<>();
//
//       for(int course = 0; course<numCourse; course++) {
//           graph.add(new ArrayList<>());
//       }
//
//       for(int[] preRequsite: prequsities) {
//           int course = preRequsite[0];
//           int preReq = preRequsite[1];
//
//           graph.get(preReq).add(course);
//       }
//
//       boolean[] visited = new boolean[numCourse];
//       boolean[] pathVisited = new boolean[numCourse];
//       for(int course=0; course<numCourse; course++) {
//           if(!visited[course]) {
//               if(dfs(course, graph, visited, pathVisited)) {
//                   return false;
//               }
//           }
//       }
//
//       return true;
//    }
//    private static boolean dfs(int course , List<List<Integer>> graph, boolean[] visited, boolean[] pathVisited) {
//        visited[course] = true;
//        pathVisited[course] = true;
//
//        for(int neighbour: graph.get(course)) {
//             if(!visited(neighbour)) {
//            if(dfs(neighbour, graph, visited, pathVisited)) {
//                return true;
//            }
//           }
//            else if(pathVisited[neighbour]) {
//                return true;
//            }
//        }
//
//        pathVisited[course] = false;
//
//        return false;
//    }
}
