// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Solution {
    ArrayList<String> ans;
    void fun(int n, int open, int close, String op){
        if(open+close==n){
          ans.add(op);
          return;
        } 
        if(open==close){
            String op1 = op + "1";
            fun(n,open+1,close,op1);
        }
        if(open>close){
            String op1 = op + "1";
            fun(n,open+1,close,op1);
            String op2 = op+'0';
            fun(n,open,close+1,op2);
        }
    }
    ArrayList<String> NBitBinary(int N) {
        // code herev
        ans=new ArrayList<String>();
        int open = 0;
        int close = 0;
        int bal=N;
        String op ="";
        fun(bal,open,close,op);
        return ans;
    }
}