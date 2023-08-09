//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.oddAndEven(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int oddAndEven(String S) {
        // code here
        int s1 = 0;
        int s2 = 0;
        for(int i=0;i<S.length();i++) {
            if(i%2==0) s1+=Character.getNumericValue(S.charAt(i));
            else s2+=Character.getNumericValue(S.charAt(i));
        }
        return s1==s2 ? 1 : 0;
    }
}