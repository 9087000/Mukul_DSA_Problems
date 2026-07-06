package DSASheet.Grpahs;

import java.util.HashSet;
import java.util.Set;

public class MostStoneRemovedwithsamerowOrcolumn {
    public static void main(String[] args) {
        int[][] stones = {{0,0}, {0,1}, {1,0} ,{1,2}, {2,1}, {2,2}};
        int stone = mostStoneRemove(stones);
        System.out.println(stone);
    }
    //optimized
    //Instead of connecting stone to stone
    // Treat
    // every row
    // DSU node
    // every col
    // DSU node
    // Every stone
    // (row , col)
    // means
    // union(row, col  + offset)
    // why offset?
    // Every stone
    // row 2
    // col 2
    // means share same node
    // so to avoid collision
    // row
    // 0 ... Maxrow
    // col
    // offset... offSet+ maxcol
    // parent[]
    // |
    // rank[]
    // |
    //  intialize hashset nodes
    // |
    //  Loop through nodes
    // |
    //  row = stone[0]
    // |
    // col = stone[1] + offset
    // |
    // union(parent, rank, row, col)
    // |
    // add the row and col to usedRows
    // |
    //  loop through usedRows
    // |
    // find ultimate parent
    // |
    // add the ultimateparent to new hashset
    // |
    //  return stones.length - set.size()
    // findParent
    // check parent[node] == node
    // |
    // return node
    // |
    // parent[node] = find(parent, parent[node])
    // |
    //  return parent[node]
    // union
    // find parentU with node as u
    // |
    // find parentV with node as v
    // |
    //  check parentU == parentV return
    // |
    // check rank[parentU] < rank[parentV] return parent[parentU] = parentV
    // |
    // check rank[parentV] > rank[parentU] return parent[parentV] = parentU
    // |
    //  parent[parentV] = parentU
    //  rank[parentU]++
    // T.C: o(N)
    // S.C : o(R + C)
    // n = stones.length
    // int offset = 10001
    // int[] parent = new int[20002]
    // int[] rank = new int[20002]
    // for i from 0 to n - 1
    // parent[i] = i
    // Set<Integer> usedRows = new HashSet<>()
    // for int[] stone to stones
    // row = stones[0]
    // col = stone[1] + offset
    // union(parent, rank, row, col)
    // usedrows.add(row)
    // usedrows.add(col)
    // Set<Integer> set = new HashSet<>()
    // for node to usedRows
    // set.add(find(parent, node)
    // return n - set.size()
    // findParent
    // if parent[node] == node
    // return node
    // parent[node] = find(parent, parent[node])
    // return parent[node]
    // rank
    // parentU = find(parent, u)
    // parentV = find(parent, v)
    // if(parentU == parentV) return
    // if rank[parentU] < rank[parentV]
    // parent[parentU] = parentV
    // else if rank[parentU] > rank[parentV]
    // parent[parentV] = parentU
    // else
    // parent[parentV] = parentU
    // rank[parentU]++
    private static int mostStoneRemove(int[][] stones) {
        int n = stones.length;
        int offset = 10001;

        int[] parent = new int[20002];
        int[] rank = new int[20002];

        for (int i=0; i<parent.length; i++) {
            parent[i] = i;
        }

        Set<Integer> usedRows = new HashSet<>();

        for(int[] stone: stones) {
            int row = stone[0];
            int col = stone[1] + offset;

            union(parent, rank, row, col);

            usedRows.add(row);
            usedRows.add(col);
        }

        Set<Integer> stone = new HashSet<>();

        for(int node: usedRows) {
            stone.add(find(parent, node));
        }

        return n - stone.size();
    }

    private static int find(int[] parent, int node) {
        if(parent[node] == node) {
            return node;
        }

        parent[node] = find(parent, parent[node]);
        return parent[node];
    }

    private static void union(int[] parent, int[] rank, int u, int v) {
        int parentU = find(parent, u);
        int parentV = find(parent, v);

        if(parentU == parentV) return;

        if(rank[parentU] < rank[parentV]) {
            parent[parentU] = parentV;
        } else if(rank[parentU] > rank[parentV]) {
            parent[parentV] = parentU;
        } else {
            parent[parentV] = parentU;
            rank[parentU]++;
        }
    }
    //brute
    // Every connected group of stones must leave behind atleast one stone
    // Maximum number of stones removed  = stones.length - component.size()
    // Treat every stone as graph node
    // Two components are connected if
    // same row or same column
    // Run dfs on every connected component
    // visited[]
    // |
    // intliaze component
    // |
    // if it is not visited
    // |
    // increment component
    // |
    // Run dfs on connected component
    // |
    //  return stones.length - component.size()
    // dfs
    // mak the visited[current] = true
    // |
    // loop thorugh neighbour
    // |
    // not visited and same row and same col
    // |
    //  true
    // |
    // run dfs on neighbour
    // T.C : o(N2)
    // S.C : o(N)
    // n = stones.length
    // boolean[] visited = new boolean[n]
    // component = 0;
    // for i from 0 to n - 1
    // if it is not !visited[i]
    // component++
    // dfs(i, stones, visited)
    // return n - component.size()
    // dfs
    // visited[current] = true
    // for int neighbour from 0 to stones.length
    // if !visited[neighbour] && (stones[current][0] == stones[neighbour][0] || stones[current][1] == stones[neighbour][1])
    // dfs(neighbour, stones, visited)
//    private static int mostStoneRemove(int[][] stones) {
//        int n = stones.length;
//
//        boolean[] visited = new boolean[n];
//        int component = 0;
//        for(int i=0; i<n; i++) {
//            if(!visited[i]) {
//                dfs(stones, i, visited);
//                component++;
//            }
//        }
//
//        return n - component;
//    }
//    private static void dfs(int[][] stones, int city, boolean[] visited) {
//        visited[city] = true;
//        for(int neighbour = 0; neighbour<stones.length; neighbour++) {
//            if(!visited[neighbour] && (stones[city][0] == stones[neighbour][0] || stones[city][1] == stones[neighbour][1])) {
//                dfs(stones, neighbour, visited);
//            }
//        }
//    }
}
