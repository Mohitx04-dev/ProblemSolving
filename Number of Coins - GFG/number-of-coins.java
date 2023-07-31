//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{
    int[][] dp;
    int fun(int i, int[] coins, int V) {
        if(V==0) return 0;
        if(i==coins.length || V<0) return (int)1e9;
        if(dp[i][V]!=0) return dp[i][V];
        return dp[i][V] = Math.min(1 + fun(i,coins,V-coins[i]), fun(i+1,coins,V));
    }
	public int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	   dp = new int[M+1][V+1];
	   int v = fun(0,coins,V);
	   return v > (int)1e8 ? -1 : v; 
	} 
}