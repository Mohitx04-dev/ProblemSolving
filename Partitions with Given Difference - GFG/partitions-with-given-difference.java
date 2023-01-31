//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int d=sc.nextInt();
            
            int []arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            
            Solution obj=new Solution();
            int res=obj.countPartitions(n, d, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//Back-end complete function Template for Java

class Solution{

    public int countPartitions(int N, int d, int arr[]){
        // Code here
        int sum=0;
        for(int i=0;i<N;i++) sum+=arr[i];
        if((sum+d)%2!=0) return 0;
        sum = (sum+d)/2;
        double mod = 1e9+7;
	    int[][] dp = new int[N+1][sum+1];
	    dp[0][0] = 1;
        for(int i=1; i<=N; i++){
           for(int j=0; j<=sum; j++) {
              if(arr[i-1]<=j) dp[i][j] = dp[i-1][j]%(int)mod+ dp[i-1][j-arr[i-1]]%(int)mod;
              else dp[i][j] = dp[i-1][j]%(int)mod;
           }
        }
        return dp[N][sum]%(int)mod;
    }
}