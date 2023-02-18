//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    boolean detectD(boolean[] vis, int V, ArrayList<ArrayList<Integer>> adj, int node, int parent,boolean[] pVis) {
        vis[node] = true;
        pVis[node] = true;
        for(int x : adj.get(node)) {
            if(!vis[x]) {
                if(detectD(vis,V,adj,x,node,pVis)==true) return true;
            }
            else if(pVis[x]) {
                 return true;
            }
        }
        pVis[node] = false;
        return false;
    }
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
       boolean[] vis = new boolean[V];
       for(int i=0;i<V; i++) {
           if(!vis[i]) if(detectD(vis,V, adj,i,-1, new boolean[V])) return true;
       }
       return false;
    }
}