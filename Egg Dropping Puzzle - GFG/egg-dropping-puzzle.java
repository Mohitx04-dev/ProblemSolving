//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}



// } Driver Code Ends


class Solution 
{
    static int[][] dp;
    static int fun(int n, int k){
        if(n==1 || k==1 || k==0) return dp[n][k] = k;
	    int min = Integer.MAX_VALUE;
	    if(dp[n][k]!=0) return dp[n][k];
	    for(int i=1;i<=k; i++){
	        int t1,t2;
	        if(dp[n-1][i-1]!=0) t1=dp[n-1][i-1];
	        else t1 = fun(n-1,i-1);
	        if(dp[n][k-i]!=0) t2=dp[n][k-i];
	        else t2 = fun(n,k-i);
	        int temp = 1 + Math.max(t1,t2);
	        min = Math.min(temp,min);
	    }
        return dp[n][k] = min;
    }
    //Function to find minimum number of attempts needed in 
    static int eggDrop(int n, int k) 
	{
	   dp =  new int[n+1][k+1];
	    // Your code here
	   fun(n,k);
	   return dp[n][k];
	}
}