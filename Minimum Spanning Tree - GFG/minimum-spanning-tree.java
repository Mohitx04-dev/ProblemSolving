//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    int[][] adj = new int[V][V];
	    for(int i=0;i<V;i++) {
	        Arrays.fill(adj[i],-1);
	        adj[i][i] = 0;
	    }
	    for(int [] edge : edges) {
	        adj[edge[0]][edge[1]] = edge[2];
	        adj[edge[1]][edge[0]] = edge[2];
	    }
	    int[] vis = new int[V];
	    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->a[0]-b[0]);
	    pq.add(new int[]{0,0,-1});
	    int ans = 0;
	    while(!pq.isEmpty()) {
	        int[] node = pq.poll();
	        if(vis[node[1]]==1) continue;
	        vis[node[1]] = 1;
	        ans+=node[0];
	        for(int i=0;i<V;i++) {
	            if(i!=node[1] && adj[node[1]][i]!=-1 && vis[i]==0 && i!=node[2])  {
	                pq.add(new int[] {adj[node[1]][i],i,node[1]});
	            }
	        }
	    }
	    return ans;
	}
}