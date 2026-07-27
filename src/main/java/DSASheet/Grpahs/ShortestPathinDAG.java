package DSASheet.Grpahs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathinDAG {
    public static void main(String[] args) {
        int[][] edges = {{0,1,2},{0,2,1}};
        int V = 4;
        int E = 2;
        int[] DAG = shortestPath(edges, V, E);
        System.out.println(Arrays.toString(DAG));
    }

    //brute
    // Try possible path using DFS
    // Maintain
    // currentDistance
    // whenever smaller distance is found
    // update
    // distance[currentNode]
    // continue DFS
    // Build Graph
    // |
    //  distance[] = INF
    // |
    // dfs(0)
    // |
    //  visit neighbour
    // |
    // smaller Distance?
    // |
    // update
    // |
    // continue DFs
    // |
    //  Convert INT to -1
    // DFS explores every possible
    // whenever node with smaller distance is reached
    // update and explore it.
    // The DAG has no cycles recursion terminates it abruptly
    // T.C : o(2^V)
    // S.C : o(V + E)
    // List<List<int[]>> graph = new ArrayList<>()
    // for int i from 0 to V
    // graph.add(new ArrayList<>())
    // for int[] edge : edges
    // int src = edge[0]
    // dest = edge[1]
    // target = edge[2]
    // graph.get(src).add(new int[]{dest, target})
    // int[] distance = new int[V]
    // Arrays.fill(distance, Integer.MAX_VALUE)
    // dfs(graph, 0,o, distance)
    // for int i from 0 to V
    // if distance[i] == Integer.MAX_VALUE
    // distance[i] = -1
    // return distance
    // dfs
    // if currentDistance> distance[currentNode]
    // return
    // distance[currentNode] = currentDistance
    // for int[] neighbour : graph.get(currentNode))
    // int nextNode = neighbour[0]
    // weight = neighbour[1]
    // dfs(graph, nextNode, currentDistance + weight, distance)
     private static int[] shortestPath(int[][] edges, int V, int E) {
        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0; i<V; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            int source = edge[0];
            int dest = edge[1];
            int weight = edge[2];

            graph.get(source).add(new int[]{dest, weight});
        }

        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);

        dfs(graph, 0, 0, distance);

        for(int i=0; i<V; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        return distance;
    }

    private static void dfs(List<List<int[]>> graph, int currentNode, int currentDistance, int[] distance) {
        if(currentDistance >= distance[currentNode]) {
            return;
        }

        distance[currentNode] = currentDistance;

        for(int[] neighbour: graph.get(currentNode)) {
            int nextNode = neighbour[0];
            int weight = neighbour[1];

            dfs(graph, nextNode, currentDistance + weight, distance);
        }
    }
//    //optimized
    // Instead of exploring every path
    // Process each node
    // in topological order
    // when a node is processed all predeceders are have been calcualted already
    // Every outgoing edge relaxed exactly once
    // Build graph
    // |
    // Topological sort
    // |
    // push nodes into stack
    // |
    // distance[0] = 0
    // |
    // pop stack
    // |
    // reachable?
    // |
    // relax every edge
    // |
    //  update distance
    // |
    // convert INF to -1
    // |
    // return distance
    // List<List<int[]>>
    // stores
    // destination
    // weight
    // Stack
    // stores
    // Topological order
    // distance
    // shortest path from source to node
    // distance[0] = 0
    // Relaxation
    // CurrentNode
    // |
    // neighbour
    // |
    //  weight
    // new Distance
    // newDistance = distance[currentNode] + weight
    // compare
    // newDistance < distance[nextNode]
    // update
    // T.C: o(V + E)
    // S.C : o(V + E)
    // List<List<int[]>> graph
    // for int i from 0 to V
    // graph.add(new ArrayList<>())
    // for int[] edge: edges
    // int src = edge[0]
    // dest = edge[1]
    // weight = edge[2]
    // graph.get(src).add(new int[]{dest,weight})
    // boolean[] visited = new boolean[V]
    // Stack<Integer> stack = new Stac<>();
    // for int i from 0 to V
    // if !visited[i]
    // dfs graph, i, visited, stack
    // int[] distance = new int[V]
    // Arrays.fill(distance, Integer.MAX_VALUE)
    // distance[0] = 0
    // while !stack.isEmpty()
    // int currentNode = stack.pop()
    // if distance[currentNode] == Integer.MAX_VALUE
    // continue
    // for int neighbour[] : graph.get(currentNode)
    // newNode = neighbour[0]
    // weight = neighbour[1]
    // int newDistance = distance[currentNode] + weight
    // if(newDistance < distance[newNode])
    // distance[newNode] = newDistance
    // for int i from 0 to V
    // if distance[i] == Integer.MAX_VALUE
    // distance[i] = -1
    // return distance
    // dfs
    // visited[currentNode] = true
    // for int[] neighbour: graph.get(currentNode))
    // nextNode = neighbour
    // !visited[nextNode]
    // dfs(graph, nextNode, visited, stack
    // stack.push(currentNode)
//    private static int[] shortestPath(int[][] edges , int V , int E) {
//        List<List<int[]>> graph = new ArrayList<>();
//        for(int i=0; i<=V; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        for(int[] edge : edges) {
//            int edgei = edge[0];
//            int edge1 = edge[1];
//            int edge2 = edge[2];
//            graph.get(edgei).add(new int[]{edge1, edge2});
//        }
//
//        boolean[] visited = new boolean[V];
//        Stack<Integer> stack = new Stack<>();
//
//        for(int i=0; i<V; i++) {
//            if(!visited[i]) {
//                dfs(graph, i, visited, stack);
//            }
//        }
//
//        int[] distance = new int[V];
//        Arrays.fill(distance, Integer.MAX_VALUE);
//        distance[0] = 0;
//
//        while(!stack.isEmpty()) {
//            int currentNode = stack.pop();
//            if(distance[currentNode] == Integer.MAX_VALUE) {
//                continue;
//            }
//            for(int[] neigbhour : graph.get(currentNode)) {
//                int nextNode = neigbhour[0];
//                int weight = neigbhour[1];
//
//                int newDistance = distance[currentNode] + weight;
//
//                if(newDistance < distance[nextNode]) {
//                    distance[nextNode] = newDistance;
//                }
//            }
//        }
//
//        for(int i=0; i<V; i++) {
//            if(distance[i] == Integer.MAX_VALUE) {
//                distance[i] = -1;
//            }
//        }
//
//        return distance;
//    }
//
//    private static void dfs(List<List<int[]>> graph, int currentNode, boolean[] visited, Stack<Integer> distance) {
//        visited[currentNode] = true;
//
//        for(int[] neighbour : graph.get(currentNode)) {
//            int nextNode = neighbour[0];
//
//            if(!visited[nextNode]) {
//                dfs(graph, nextNode, visited, distance);
//            }
//        }
//
//        distance.push(currentNode);
//    }
}
