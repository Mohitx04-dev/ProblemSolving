//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().removals(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int[][] dp;
    int fun(int i, int j, int k, int[] arr)  {
        if(j<i) return Integer.MAX_VALUE;
        if(arr[j]-arr[i]<=k) return 0;
        if(dp[i][j]!=0) return dp[i][j];
        return dp[i][j] = Math.min(1 + fun(i+1,j,k,arr), 1 + fun(i,j-1,k,arr));
    }
    int removals(int[] arr, int n, int k) {
        // code here
        dp = new int[n][n];
        Arrays.sort(arr);
        return fun(0,n-1,k,arr);
    }
}