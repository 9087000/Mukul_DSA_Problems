package DSASheet.Grpahs;

import java.util.*;

public class Kahnsalgorithm {
    public static void main(String[] args) {
        int V = 6;
        int[][] edges = {{5,2},{5,0},{4,0},{4,1},{2,3},{3,1}};
        int[] topologicalOrder = kahnsalgorithm(V, edges);
        System.out.println(Arrays.toString(topologicalOrder));
    }
    // Build Graph
    // |
    // calculate indegree
    // |
    //  Queue
    // |
    // push every node with indegree = 0
    //  |
    //  pop node
    // |
    // store in answer
    // |
    // visit neighbour
    // |
    //  decrease their indegree
    // |
    //  push neighbour into queue if indegree  =0
    // |
    // Repeat
    // T.C : o(V + E)
    // S.C : o(V + E)
    // List<List<Integer>> graph = new ArrayList<>()
    // for int i from 0 to V
    // graph.add(new ArrayList<>())
    // int[] indegree = new int[V]
    // for int[] edge : edges
    // int src = edge[0]
    // int dest = edge[1]
    // graph.get(src).add(dest)
    // indegree[dest]++
    // Queue<Integer> queue = new LinkedList<>()
    // for int node from 0 to V
    // if indegree[node] == 0
    // queue.offer(node)
    // int[] topologicalOrder = new int[V]
    // index = 0
    // while !queue.isEmpty()
    // currentNode = queue.pop()
    // indegree[index++] = currentNode;
    // for int[] neighbour : graph.get(currentNode)
    // indegree[neighbour]--
    // if indegree[neighbour] == 0
    // queue.offer(neighbour)
    // if (index != V)
    // return new int[0];
    // return topological order
    private static int[] kahnsalgorithm(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<V; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[V];
        for(int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];

            graph.get(src).add(dest);
            indegree[dest]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int node=0; node<V ;node++) {
           if(indegree[node] == 0) {
               queue.offer(node);
            }
        }

        int[] topologicalOrder = new int[V];
        int index = 0;

        while(!queue.isEmpty()) {
            int currentNode = queue.poll();

            topologicalOrder[index++]= currentNode;

            for(int neighbour : graph.get(currentNode)) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        if(index != V) {
            return new int[0];
        }

        return topologicalOrder;
    }
}
