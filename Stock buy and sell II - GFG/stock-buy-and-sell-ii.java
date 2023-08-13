//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] prices = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.stockBuyAndSell(n, prices);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    static int[][] dp;
    static int fun(int i, int canBuy, int[] p){
        if(i>=p.length) return 0;
        if(dp[i][canBuy]!=-1) return dp[i][canBuy];
        if(canBuy==1) {
            return dp[i][canBuy] =  Math.max(-p[i] + fun(i+1,0,p), fun(i+1,1,p));
        }
        else return dp[i][canBuy] = Math.max(p[i] + fun(i+1,1,p), fun(i+1,0,p));
    }
    public static int stockBuyAndSell(int n, int[] prices) {
        // code here
        dp = new int[n][2];
        for(int[] m : dp) Arrays.fill(m,-1);
        return fun(0,1,prices);
    }
}
        
