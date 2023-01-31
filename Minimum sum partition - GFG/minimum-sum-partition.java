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
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int N) 
	{ 
	    // Your code goes here
	    int sum=0;
        for(int i=0;i<N;i++) sum+=arr[i];
        int[] t = new int[sum+1];
        boolean[][] dp = new boolean[N+1][sum+1];
          for(int i=0; i<=N; i++){
           for(int j=0; j<=sum; j++) {
              if(i==0 && j==0) dp[i][j] = true;
              else if(i==0) dp[i][j] = false;
              else if(j==0) dp[i][j] = true;
              else if(arr[i-1]<=j) dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
              else dp[i][j] = dp[i-1][j];
              if(dp[N][j]) t[j]=1;
           }
        }
        int ans=Integer.MIN_VALUE;
        for(int i=0; i<=sum/2; i++) {
            if(t[i]==1) ans = Math.max(ans, i);
        }
        return sum-2*ans;
	} 
}
