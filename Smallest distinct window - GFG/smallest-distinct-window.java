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
        int[] freq = new int[60];
        int c = 0;
        for(int i=0;i<str.length();i++) {
            if(freq[str.charAt(i)-'A']==0) c++;
            freq[str.charAt(i)-'A']++;
        }
        for(int k=c;k<=str.length();k++) {
            int i = 0;
            int j = 0;
            int x = 0;
            freq = new int[60];
            while(j<str.length()) {
               if(freq[str.charAt(j)-'A']==0) x++;
               if(x==c) {
                   return k;
               }
               freq[str.charAt(j)-'A']++; 
               if(j-i+1 < k) j++;
               else if(j-i+1 == k) {
                   freq[str.charAt(i)-'A']--;
                   if(freq[str.charAt(i)-'A']==0) x--;
                   i++;
                   j++;
               }
            }
        }
        return -1;
    }
}