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
	    ArrayList<ArrayList<int[]>> adj = new ArrayList<ArrayList<int[]>>();
	    for(int i=0;i<V;i++) adj.add(new ArrayList<int[]>());
	    for(int[] e : edges){ 
	        adj.get(e[0]).add(new int[]{e[1],e[2]});
	        adj.get(e[1]).add(new int[]{e[0],e[2]});
	    }
	    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((int[]e1, int[]e2)->e1[0]-e2[0]);
	    pq.add(new int[]{0,0,-1});
	    boolean vis[] = new boolean[V];
	    int ans = 0;
	    while(!pq.isEmpty()) {
	        int[] t = pq.poll();
	        if(vis[t[1]]) continue;
	            vis[t[1]] = true;
	            ans+=t[0];
	        
	        for(int[] e : adj.get(t[1])) {
	            if(!vis[e[0]]) pq.add(new int[]{e[1],e[0],t[1]});
	        }
	    }
	    return ans;
	}
	
}