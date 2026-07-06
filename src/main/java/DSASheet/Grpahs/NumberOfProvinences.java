package DSASheet.Grpahs;

public class NumberOfProvinences {
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        int provinces = numberOfProvinces(isConnected);
        System.out.println(provinces);
    }
    //optimized
    // create parent array of size n
    // intialize , all the city with it own parent
    // parent[i] = i
    // Traverse matrix
    // if the isConnected[i][j] == 1
    // union of i th and jth city and parent
    // intialize provinence = 0
    // loop through city from 0 to n - 1
    // find(x) returns the ulitmate parent of city x
    // path comparision make the future find() faster
    // After all unions, count all cities
    //  find(i) = i
    // return provinence
    // T.C : o(n2 * alpha(n)) i.e o(n2)
    // S.C : o(n)
    private static int numberOfProvinces(int[][] isConnected) {
        int n = isConnected.length;
        int[] parent = new int[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(isConnected[i][j] == 1) {
                    union(i,j, parent);
                }
            }
        }

        int provinence = 0;

        for(int i=0; i<n; i++) {
            if(find(parent, i) == i) {
                provinence++;
            }
        }

        return provinence;
    }

    private static int find(int[] parent, int node) {
        if(parent[node] == node) {
            return node;
        }

        parent[node] = find(parent, parent[node]);
        return parent[node];
    }
    private static void union(int u, int v, int[] parent) {
        int parentU = find(parent, u);
        int parentV = find(parent, v);

        if(parentU != parentV) {
            parent[parentV] = parentU;
        }
    }
    //brute
    // n = isConnected.length
    // Create a boolean[] visited = new boolean[n]
    // intialize provinence = 0
    // loop through city from 0 to n - 1
    // if the visited[city] is not equal
    // provinence++
    // dfs on the city
    // dfs marks the city as visited
    // loop through the neighbour from  0 to n - 1
    // if the isConnected[city][neighbour] == 1 and neighbour is not visited
    // then dfs on the city with neighbour
    // return provinence
    // T.C : o(n2)
    // S.C : o(n)
//    private static int numberOfProvinces(int[][] isConnected){
//        int n = isConnected.length;
//
//        boolean[] isVisited = new boolean[n];
//        int province = 0;
//        for(int city=0; city<n; city++) {
//                if(!isVisited[city]) {
//                    province++;
//                    dfs(isConnected, city, isVisited);
//                }
//        }
//
//        return province;
//    }
//    private static void dfs(int[][] isConnected, int city, boolean[] isVisited) {
//        for(int neighbour = 0; neighbour<isConnected.length; neighbour++) {
//            isVisited[city] = true;
//            if (isConnected[city][neighbour] ==1 && !isVisited[neighbour]){
//                dfs(isConnected, neighbour, isVisited);
//                dfs(isConnected, neighbour, isVisited);
//            }
//        }
//    }
}
