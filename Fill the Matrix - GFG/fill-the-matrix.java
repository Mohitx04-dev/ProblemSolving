//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
	public static int minIteration(int N, int M, int x, int y){
		//code here
		Queue<int[]> queue = new LinkedList<int[]>();
	    queue.add(new int[]{x-1,y-1});
	    int[][] dirs = new int[][]{{1,0},{0,1},{0,-1},{-1,0}};
	    int[][] vis = new int[N][M];
	    int ans = 0;
	    while(!queue.isEmpty()) {
	        int s = queue.size();
	        ans++;
	        while(s-->0) {
	            int[] node = queue.poll();
	            int i = node[0];
	            int j = node[1];
	            for(int[] d : dirs) {
	                int p = d[0] + i;
	                int q = d[1] + j;
	                if(p<0 || q<0 || p>=N || q>=M) continue;
	                if(vis[p][q]==1) continue;
	                vis[p][q] = 1;
	                queue.add(new int[]{p,q});
	            }
	        }
	    }
	    return ans-1;
	}
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String input[]=read.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int M=Integer.parseInt(input[1]);
           	input=read.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.minIteration(N, M, x, y));
        }
        
    }
}
// } Driver Code Ends