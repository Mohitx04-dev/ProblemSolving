//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.shortestUnorderedSubarray(a, n));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public long shortestUnorderedSubarray(long arr[], long n)
    {
        if(n<=2) return 0;
        for(int i=1;i<n-1;i++) {
            if((arr[i]>arr[i+1] && arr[i]>arr[i-1])||(arr[i]<arr[i+1] && arr[i]<arr[i-1])) return 3;
        }
        return 0;
    }
}