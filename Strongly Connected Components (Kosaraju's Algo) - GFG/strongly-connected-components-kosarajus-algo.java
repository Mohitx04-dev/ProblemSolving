//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    void dfs(int node,  ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> st, int mode) {
        vis[node] = 1;
        for(int x : adj.get(node)) {
            if(vis[x]==0){ 
                dfs(x,adj,vis,st,mode);
            }
        }
        if(mode==1) {
        st.push(node);
        }
    } 
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer> st = new Stack<Integer>();
        int[] vis = new int[V];
        for(int i=0;i<V; i++) {
            if(vis[i]==0) dfs(i,adj,vis,st,1);
        }
        ArrayList<ArrayList<Integer>> adjt = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V; i++) adjt.add(new ArrayList<Integer>());
        for(int i=0; i<adj.size(); i++) {
            for(int j=0;j<adj.get(i).size(); j++) {
                int el = adj.get(i).get(j);
                adjt.get(el).add(i);
            }
        }
        vis = new int[V];
        int count=0;
        while(!st.isEmpty()) {
            int node = st.pop();
            if(vis[node]==0){
                 count++;
                 dfs(node,adjt,vis,st,2);
            }
        }
        return count;
    }
}
