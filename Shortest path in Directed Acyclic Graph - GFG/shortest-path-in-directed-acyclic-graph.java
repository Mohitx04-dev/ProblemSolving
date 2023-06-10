//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    void dfs(int src, int[] dist, int[][] adj) {
        for(int i=0;i<dist.length;i++) {
            if(adj[src][i]>0) {
                if(dist[i] > dist[src] + adj[src][i]) 
                {
                    dist[i] = dist[src] + adj[src][i];
                    dfs(i,dist,adj);
                }
            }
        }
    }
	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
	    int[] dist = new int[N];
	    Arrays.fill(dist,(int)1e9);
	    dist[0] = 0;
	    int[][] adj = new int[N][N];
	    for(int [] e : edges) {
	        adj[e[0]][e[1]] = e[2];
	    }
	    dfs(0,dist,adj);
	    for(int i=0;i<dist.length;i++) {
	        if(dist[i] == (int)1e9) dist[i] = -1;
	    }
	    return dist;
	}
}