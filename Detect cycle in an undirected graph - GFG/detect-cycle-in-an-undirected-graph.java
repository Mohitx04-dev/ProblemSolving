//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

class Pair {
    public int p;
    public int c;
    public Pair(int c , int p) {
        this.c = c;
        this.p = p;
    }
}
class Solution {
    // Function to detect cycle in an undirected graph.
    boolean detect(boolean[] vis, int V, ArrayList<ArrayList<Integer>> adj, int node) {
        Queue<Pair> q = new LinkedList<Pair>();
        vis[node] = true;
        q.add(new Pair(node,-1));
        while(!q.isEmpty()) {
            Pair n = q.poll();
            for(int x : adj.get(n.c)) {
                if(vis[x]){
                    if(x!=n.p) return true;
                }
                else{
                    vis[x] = true;
                    q.add(new Pair(x,n.c));
                }
            }
        }
        return false;
    }
    boolean detectD(boolean[] vis, int V, ArrayList<ArrayList<Integer>> adj, int node, int parent ) {
        vis[node] = true;
        for(int x : adj.get(node)) {
            if(!vis[x]) {
                if(detectD(vis,V,adj,x,node)==true) return true;
            }
            else if(x!=parent) {
                 return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
       boolean[] vis = new boolean[V];
       for(int i=0;i<V; i++) {
           if(!vis[i]) if(detectD(vis,V, adj,i,-1)) return true;
       }
       return false;
    }
}