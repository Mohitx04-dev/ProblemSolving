//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int[][] dp;
    static int solve(int arr[], int i, int j) {
        if(i>=j) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        int ans=Integer.MAX_VALUE;
        for(int k=i; k<j; k++) {
            int t = solve(arr,i,k)  + (arr[i-1]*arr[k]*arr[j]) + solve(arr,k+1,j);
            ans = Math.min(t, ans);
        }
        return dp[i][j] = ans;
    }
    static int matrixMultiplication(int N, int arr[])
    {
        dp = new int[N+1][N+1];
        return solve(arr,1, N-1);
    }
}