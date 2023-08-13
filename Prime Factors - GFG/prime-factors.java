//{ Driver Code Starts


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int[] ans = ob.AllPrimeFactors(N);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends




class Solution
{
    public int[] AllPrimeFactors(int N)
    {
        // code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i=2;i<=N;i++) {
            while(N>1 && N%i==0) {
                if(ans.size()==0) ans.add(i);
                else if(ans.get(ans.size()-1)!=i) ans.add(i);
                N = N/i;
            }
        }
        int[] arr = new int[ans.size()];
        for(int i=0;i<arr.length;i++) arr[i] = ans.get(i);
        return arr;
    }
}