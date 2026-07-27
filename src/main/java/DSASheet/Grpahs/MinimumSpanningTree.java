package DSASheet.Grpahs;

import java.util.*;

public class MinimumSpanningTree {
    public static void main(String[] args) {
        int[][] edges = {{0,1,5}, {1,2,3}, {0,2,1}};
        int V = 3;
        int spanning = spanningTree(V, edges);
        System.out.println(spanning);
    }
    //optimized
    // in prims brute
    // To get minimum weight edge in  the cheapest unvisited vertex
    // We scan all the vertex
    // |
    //  Repeatedly untill V times
    // |
    // so it beacomes o(v ^ 2)
    // optimized
    // use minimum priorityQueue
    // |
    // priorityQueue stores
    // edgeWeight , node
    // |
    // The minimum connecting edge node is removed at first itself
    // |
    // No need to scan all vertex
    // T.C: o(E log V)
    // S.C : o(V + E)
    // List<List<int[]>> graph = new ArrayList<>()
    // for int i from 0 to V
    // graph.add(new ArrayList<>())
    // for int[] edge : edges
    // src = edge[0]
    // dest = edge[1]
    // weight = edge[2]
    // graph.get(src).add(new int[]{dest, weight}}
    // graph.get(dest).add(new int[]{src, weight})
    //boolean[] visited = new boolean[V]
    // PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]))
    // queue.offer(new int[]{0,0})
    // mstWeight = 0
    // nodeSsIncluded
    // while !queue.isEmpty()
    // int[] current = queue.poll()
    // node = current[0]
    // weight = current[1]
    // if(visited[node])
    // continue
    // visited[node] = true
    // mstWeight += weight
    // nodesIncluded++
    // for int[] neighbour : graph.get(node))
    // nextNode = neighbour[0]
    // nextweight = neighbour[1]
    // if !visited[nextNode]
    // queue.offer(new int[]{nextweight, nextNode})
    // return nodesIncluded == V ? -1 : mstWeight
    private static int spanningTree(int V, int[][] edges) {
        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0; i<V; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            int weight = edge[2];

            graph.get(src).add(new int[]{dest, weight});
            graph.get(dest).add(new int[]{src, weight});
        }

        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        queue.offer(new int[]{0,0});
        int mstWeight = 0;
        int nodesIncluded = 0;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            int weight = current[0];
            int node = current[1];

            if(visited[node]) {
                continue;
            }

            visited[node] = true;
            mstWeight += weight;
            nodesIncluded++;

            for(int[] neighbour : graph.get(node)) {
                int nextNode = neighbour[0];
                int nextWeight = neighbour[1];

                if(!visited[nextNode]) {
                    queue.offer(new  int[]{nextWeight, nextNode});
                }
            }
        }

        return nodesIncluded == V ? mstWeight : -1;
    }
//    //brute
    // Minimum Spanning tree
    // |
    // undirected graph
    // |
    // connect all vertex
    // |
    // Exactly v -1 vertex
    // |
    // No cycle
    // |
    // Minimum total edge weight
    //  prim's algorithm
    // start from any vertex V
    // |
    // Add it to MST
    // |
    // Find Minimum edge weight connect node to unvisited vertex
    // |
    //  Add that vertex
    // |
    // Repeat untill all nodes are included
    // Difference from dkistra
    // Dkijstra stores minimum edge  from source
    // |
    // Prim algorithm find minimum weighted edge required to connect node to vertex
    // Build adjacent undirected list
    // |
    // visited[node] check whether node is already part of MST
    // |
    // minEdge[node] check whether minimum edge weight is that connect all node to unvisited vertex
    // |
    //  Start from any vertex 0
    // |
    // minEdge[0] = 0
    // |
    // Add the minEdge[current] node to mst weight
    // |
    // Mark all node as visited
    // |
    // check all neighbour of unvisited vertex
    // |
    // if neigbhour is visited and weight is less than minEdge[weight]
    // |
    //  minEdge[weight] = node
    // return mstWeight
    // T.C: o(v ^ 2)
    // S.C : o(V + E)
    // List<List<int[]>> graph = new ArrayList<>()
    // for int i  from to V
    // graph.add(new ArrayList<>())
    // for int[] edge: edges
    // src = edge[0]
    // dest = edge[1]
    // weight = edge[2]
    // graph.get(src).add(new int[]{dest, weight})
    // graph.get(dest).add(new int[]{src, weight})
    // boolean[] visited = new boolean[V]
    // int[] minEdge = new int[V]
    // Arrays.fill(minEdge, Integer.MAX_VALUE)
    // minEdge[0] = 0
    // mstWeight = 0
    // for int count from 0 to V
    // current = -1
    // for int node from 0 to V
    // if !visited[node] && (current == -1 || minEdge[node] < minEdge[current]))
    // current = node
    // if current == -1 && minEdge[current] == Integer.MAX_VALUE
    // return -1
    // visited[current] = true
    // mstWeght += minEdge[current]
    // for int[] neighbour : graph.get(current)
    // int nextNode = neighbour[0]
    // int weight = neighbour[1]
    // if !visited[neighbpur] && weight < mibEdge[nextNode]
    // minEdge[nextNode] = weight
    // return mstWeight
//    private static int spanningTree(int V, int[][] edges) {
//        List<List<int[]>> graph = new ArrayList<>();
//
//        for(int i=0; i<V; i++) {
//            graph.add(new ArrayList<>());
//        }
//
//        for(int[] edge: edges) {
//            int src = edge[0];
//            int dest = edge[1];
//            int weight = edge[2];
//
//            graph.get(src).add(new int[]{dest, weight});
//            graph.get(dest).add(new int[]{src, weight});
//        }
//
//        boolean[] visited = new boolean[V];
//        int[] minEdge = new int[V];
//
//        Arrays.fill(minEdge, Integer.MAX_VALUE);
//        minEdge[0] = 0;
//
//        int mstWeight = 0;
//        for(int i=0; i<V; i++) {
//            int current = -1;
//
//            for(int node=0; node<V; node++) {
//                if (!visited[node] && (current == -1 || minEdge[node] < minEdge[current])) {
//                    current = node;
//                }
//            }
//                if(current == -1 || minEdge[current] == Integer.MAX_VALUE) {
//                    return -1;
//                }
//
//                visited[current] = true;
//                mstWeight += minEdge[current];
//
//                for(int[] neighbour: graph.get(current)) {
//                    int nextNode  = neighbour[0];
//                    int weight = neighbour[1];
//
//                    if(!visited[nextNode] && weight < minEdge[nextNode]) {
//                       minEdge[nextNode] = weight;
//                    }
//                }
//            }
//        return mstWeight;
//    }
}
