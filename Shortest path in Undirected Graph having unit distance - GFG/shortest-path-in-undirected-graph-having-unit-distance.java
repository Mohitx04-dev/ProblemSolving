//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    static int[] dist;
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] vis;
    // static Stack<Integer> st;
    // static void dfs(int node) {
    //     vis[node] = true;
    //     for(int x : adj.get(node)) {
    //         if(!vis[x]) dfs(x);
    //     }
    //     st.push(node);
    // }
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        dist = new int[n]; 
        Arrays.fill(dist,(int)1e9);
        adj = new ArrayList<ArrayList<Integer>>();
        // vis = new boolean[n];
        // st = new Stack<Integer>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int [] t : edges) {
            adj.get(t[1]).add(t[0]);
            adj.get(t[0]).add(t[1]);
        }
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(src);
        dist[src] = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            for(int i : adj.get(node)) {
                if(dist[i]>dist[node]+1) {
                        dist[i] = dist[node] + 1;
                        q.add(i);
                }
            }
        }
        // for(int i=0;i<n;i++) {
        //     if(!vis[i]) dfs(i);
        // }
        // dist[src]=0;
        // while(!st.isEmpty()) {
        //     int node = st.pop();
        //     int d = dist[node];
        //     for(int x : adj.get(node)) {
        //         dist[x] = Math.min(dist[x], d+1);
        //     }
        // }
        for(int i=0;i<n;i++) {
            if(dist[i]==(int)1e9) dist[i] = -1;
        }
        return dist;
    }
}