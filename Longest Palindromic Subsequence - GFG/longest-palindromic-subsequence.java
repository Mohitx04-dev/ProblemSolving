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
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String s1)
    {
        //code here
        String s2 = "";
        for(int i=s1.length()-1; i>=0; i--) s2+=s1.charAt(i); 
        int x = s1.length();
        int y = x;
        int[][] dp = new int[x+1][y+1];
        for(int i=1; i<=x; i++) {
            for(int j=1; j<=y; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[x][y];
    }
}