//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean[] vis;
    static boolean[] pvis;
    static boolean[] check;
    boolean detect(int node, List<List<Integer>> adj) {
        vis[node] = true;
        pvis[node] = true;
        for(int x : adj.get(node)){
            if(!vis[x]) { if(!detect(x,adj)) {return false; }}
            else if(pvis[x]) return false;
        }
        check[node] = true;
        pvis[node] = false;
        return true;
    }
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        vis = new boolean[V];
        pvis = new boolean[V];
        check = new boolean[V];
        List<Integer> ans = new ArrayList<Integer>();
        for(int i=0;i<V; i++) {
            if(!vis[i]) detect(i,adj);
        }
        for(int i=0; i<V; i++) {
            if(check[i]) ans.add(i);
        }
        return ans;
    }
}
