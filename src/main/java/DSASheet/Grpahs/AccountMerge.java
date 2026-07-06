package DSASheet.Grpahs;

import java.util.*;

public class AccountMerge {
    public static void main(String args[]) {
        List<List<String>> account = Arrays.asList( Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"), Arrays.asList("John","johnsmith@mail.com","john00@mail.com"),Arrays.asList("Mary","mary@mail.com"),Arrays.asList("John","johnnybravo@mail.com"));
        List<List<String>> merge = accountMerge(account);
        System.out.println(merge);
    }

    //optimized
    // Instead of comparing every account
    // Map<String , Integer>
    // key - email
    // value - account index
    // if the both account have same email
    // union both account index
    // parent[]
    // |
    // rank[]
    // |
    // email not seen
    // |
    // store email in hashmap
    // |
    //  email seen
    // |
    // union(parent, rank, i, previousIndex)
    // |
    //  find ultimate parent of account
    // |
    // group them
    // |
    // sort them
    // |
    // Add name
    // |
    // return answer
    // why union find
    // Map<String, Integer>
    // both account email have same email
    // union merge both account index
    // email - account index
    // parent - email
    // Map<Integer, List<String>>
    // T.C : o(M log M)
    // S.C : o(N + M)
    // int n = accounts.size()
    // int[] parent = new int[n]
    // int[] rank = new int[n]
    // for int i from 0 to n
    // parent[i] = i
    // Map<String, Integer> map = new HashMap<>()
    // for int i from 0 to n
    // List<String> account = accounts.get(i)
    // for j from 1 to account.size()
    // String email = account.get(j)
    // if(!map.containsKey(email))
    // map.put(email,i)
    // else
    // previousIndex = map.get(email)
    // union(parent, rank, i, previousIndex)
    // Map<Integer, List<String>> merged = new HashMap<>()
    // for String email : map.keySet()
    // int index = map.get(email)
    // int parrentNode = find(parent, index)
    // merged.computeIfAbsent(parentNode, k-> new ArrayList<>()).add(email)
    // List<List<String>> result = new ArrayList<>()
    // for Map.Entry<Integer, List<String>> entry: merged.entrySet())
    // int key = entry.getKey();
    // List<String> value = entry.getValue()
    // Collections.sort(value)
    // value.add(0, accounts.get(key).get(0)
    // result.add(list)
    // return result
    // find
    // if parent[node] == node
    // return node
    // parent[node] = find(parent, parent[node])
    // return parent[node]
    // union
    // int parentU = find(parent, u)
    // int parentV = find(parent, v)
    // if parentU == parentV return
    // if(rank[parentU] < rank[parentV])
    // parent[parentU] = parentV
    // else if (rank[parentU] > rank[parentV])
    // parent[parentV] = parentU
    // else
    // parent[parentV] = parentU
    // rank[parentU]++
    private static List<List<String>> accountMerge(List<List<String>> accounts) {
        int n = accounts.size();
        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i=0; i<n; i++) {
            parent[i] = i;
        }

        Map<String, Integer> emailToIndex = new HashMap<>();

        for(int i=0; i<n; i++) {
            List<String> email = accounts.get(i);

            for(int j=1; j<email.size(); j++) {
                String emails = email.get(j);

                if(!emailToIndex.containsKey(emails)) {
                    emailToIndex.put(emails, i);
                } else {
                    int previousIndex= emailToIndex.get(emails);
                    union(parent, rank, i , previousIndex);
                }
            }
        }

        Map<Integer, List<String>> merged = new HashMap<>();

        for(String emails: emailToIndex.keySet()) {
            int index = emailToIndex.get(emails);
            int parentD = find(parent, index);

            merged.computeIfAbsent(parentD, k -> new ArrayList<>()).add(emails);


        }

        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<Integer, List<String>> entry: merged.entrySet()) {
            int key = entry.getKey();
            List<String> value = entry.getValue();

            Collections.sort(value);
            value.add(0, accounts.get(key).get(0));
            result.add(value);
        }
        return result;
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
//    //brute
    // Treat every account as node
    // Compare every account with other account
    // If two account share atleast one email
    // merge then
    // use dfs to collect all connected account
    // visited[]
    // |
    //  loop through every account
    // |
    // Not visited
    // |
    // create set<string> merge
    // |
    // dfs
    // |
    // collect all email
    // |
    // sort them
    // |
    // Add name
    // |
    // return answer
    // dfs
    // current account
    // |
    // Mark as visited
    // |
    // add all emails into hashset
    // |
    // hasEmailAccount
    // |
    // dfs on next
    // hasEmail
    // Set<String> create
    // |
    // loop through first email
    // |
    // second email loop through
    // |
    // if set contains email
    // |
    // return true
    // |
    //  return false
    // T.C : o(N2 * M)
    // S.C ; o(N + M)
    // n =accounts.size()
    // boolean[] visited = new boolean[n]
    // List<List<String>> result = new ArrayList<>()
    // for int i from 0 to n - 1
    // if !visited[i]
    // Set<String> set = new HashSet<>()
    // dfs(i, accounts, visited, merged)
    // List<String> list = new ArrayList<>(set)
    // collections.sort(list)
    // list.add(0, accounts.get(i).get(0))
    // result.add(list)
    // return result
    // dfs
    // visited[current] = true
    // for int i from 1 to n-1
    // merged.add(accounts.get(current).get(i));
    // for int next from 1 to n - 1
    // if !visited[next] && hasAccount(account.get(current) , accounts.get(next))
    // dfs(next, accounts, visited, merged)
    // hasAccount
    // Set<String> set = new HashSet<>()
    // for int from 1 to a.size()
    // set.add(a.get(i))
    // for int i from 1 to b.size()
    // if set contains b.get(i)
    // return true
    // return false

//    private static List<List<String>> accountMerge(List<List<String>> accounts) {
//        int n =accounts.size();
//        boolean[] visited = new boolean[n];
//        List<List<String>> result = new ArrayList<>();
//
//        for(int i=0; i<n;i++) {
//            if(!visited[i]) {
//                Set<String> merged  = new HashSet<>();
//                dfs(i, accounts, visited, merged);
//                List<String> list = new ArrayList<>(merged);
//                Collections.sort(list);
//                list.add(accounts.get(i).get(0));
//                result.add(list);
//            }
//        }
//
//        return result;
//    }
//    private static void dfs(int current, List<List<String>> account, boolean[] visited, Set<String> merged) {
//        visited[current] = true;
//        for(int i=1; i<account.get(i).size(); i++) {
//            merged.add(account.get(current).get(i));
//        }
//
//        for(int next=0; next<account.size(); next++) {
//            if(!visited[next] && hasEmailAccount(account.get(current), account.get(next))) {
//                dfs(next, account, visited, merged);
//            }
//        }
//    }
//    private static boolean hasEmailAccount(List<String> a, List<String> b) {
//        Set<String> set = new HashSet<>();
//
//        for(int i=1; i<a.size(); i++) {
//            set.add(a.get(i));
//        }
//
//        for(int i=1; i<b.size(); i++) {
//            if(set.contains(b.get(i))) {
//                return true;
//            }
//        }
//
//        return false;
//    }
}
