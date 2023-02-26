//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    ArrayList<Integer> ans;
    boolean[] vis;
    int[] time;
    int[] low;
    static int t = 0;
    void dfs(int i, int parent,ArrayList<ArrayList<Integer>> adj) {
        vis[i] = true;
        time[i] = t;
        low[i] = t;
        t++;
        int child=0;
        for(int el : adj.get(i)) {
            if(el==parent) continue;
            if(!vis[el]){ 
                dfs(el,i,adj);
                low[i] =  Math.min(low[i], low[el]);
               if(parent!=-1 && low[el]>=time[i]) {
                 if(!ans.contains(i)) ans.add(i);
               }
              child++;
            }
            else{
                low[i] =  Math.min(low[i], time[el]);
            }
        }
        if(child>1 && parent==-1) if(!ans.contains(i)) ans.add(i);
     
    }
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int n,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        ans = new ArrayList<Integer>();
        vis = new boolean[n];
        time = new int[n];
        low = new int[n];
        for(int i=0;i<n;i++) {
            if(!vis[i])  dfs(i,-1,adj);
        }
    
        Collections.sort(ans);
        if(ans.size()==0) ans.add(-1);
        return ans;
    }
}