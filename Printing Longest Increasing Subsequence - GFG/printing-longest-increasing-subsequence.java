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
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            ArrayList<Integer>ans=obj.longestIncreasingSubsequence(N, arr);
            for(int i=0;i<ans.size();i++){
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public ArrayList<Integer> longestIncreasingSubsequence(int N, int arr[]){
        // Code here
        int[] dp = new int[N];
        int[] hash = new int[N];
        for(int i=0;i<N;i++) hash[i] = i;
        Arrays.fill(dp,1);
        int maxind = 0;
        int ans = 0;
        for(int i=0;i<N;i++) {
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j] && dp[i] < 1 + dp[j]) {
                    hash[i] = j;
                    dp[i] = 1 + dp[j];
                }
            }
            if(dp[i] > ans) {
                ans = dp[i];
                maxind = i;
            }
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(maxind>=0) {
            list.add(0,arr[maxind]);
            if(hash[maxind]==maxind) break;
            maxind = hash[maxind];
        }
        return list;
    }
}
