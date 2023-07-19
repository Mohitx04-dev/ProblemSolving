//{ Driver Code Starts
//Initial Template for Java

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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
        int n = nums.length;
        int[] dpi = new int[n];
        int[] dpd = new int[n];
        Arrays.fill(dpi,1);
        Arrays.fill(dpd,1);
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i] > nums[j] && dpi[i] < dpi[j] + 1) dpi[i] = 1 + dpi[j];
            }
        }
        for(int i=n-1;i>=0;i--) {
            for(int j=n-1;j>i;j--) {
                if(nums[i] > nums[j] && dpd[i] < dpd[j] + 1) dpd[i] = 1 + dpd[j];
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++) {
            ans = Math.max(ans,dpd[i] + dpi[i]-1);
        }
        return ans;
    }
}