//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String str) {
        // Your code goes here
        int i = 0;
        int j = 0;
        int d = 0;
        int ref = 0;
        int[] freq = new int[256];
        for(char t : str.toCharArray()) {
            freq[t-'A']++;
            if(freq[t-'A']==1) ref++;
        }
        freq = new int[256];
        int min = str.length();
        while(j < str.length()) {
            freq[str.charAt(j)-'A']++;
            if(freq[str.charAt(j)-'A']==1) d++;
            if(d==ref) {
                while(d==ref) {
                    min = Math.min(j-i+1, min);
                    freq[str.charAt(i)-'A']--;
                    if(freq[str.charAt(i)-'A']==0) d--;
                    i++;
                }
            }
            j++;
        }
        return min;
    }
}