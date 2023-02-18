//{ Driver Code Starts
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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    static ArrayList<ArrayList<Integer>>ad;
    static int[] color;
    static boolean[] vis;
    static boolean bfs(int node) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{node,-1});
        color[node] = 0;
        while(!q.isEmpty()) {
            int[] t = q.poll();
            vis[t[0]] = true;
            for(int x : ad.get(t[0])) {
                if(!vis[x]) {
                    color[x] = (color[t[0]]+1)%2;
                    q.add(new int[]{x,t[0]});
                }
                else if(color[x]==color[t[0]]) return false;
            }
        }
        return true;
    }
    static boolean dfs(int node) {
        if(color[node]==-1) color[node] = 0;
        for(int x : ad.get(node)) {
            if(color[x]==-1) {
                color[x] = (color[node]+1)%2;
                if(!dfs(x)) return false;
            }
            else if(color[x]==color[node]) return false;
        }
        return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        ad = adj;
        color = new int[V];
        Arrays.fill(color,-1);
        vis = new boolean[V];
        for(int i=0;i<V; i++) {
            if(color[i]==-1) {
                if(!dfs(i)) return false;
            }
        }
        return true;
    }
}