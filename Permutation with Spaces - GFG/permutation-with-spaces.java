// { Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine().trim();
            Solution ob = new Solution();
            ArrayList<String> ans = new ArrayList<String>();
            ans = ob.permutation(S);
            
            for(int i=0;i<ans.size();i++){
                System.out.print("("+ans.get(i)+")");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution{
    ArrayList<String> ans;
    void rec(String s, String op) {
        if(s.length()==0) {
            ans.add(op);
            return;
        }
        char c = s.charAt(0);
        s = s.substring(1);
        String op1 = op + ""+c;
        String op2 = op + " "+c;
        rec(s,op1);
        rec(s,op2);
    }
    ArrayList<String> permutation(String S){
        // Code Here
        ans = new ArrayList<String>();
        String x = ""+S.charAt(0);
        S = S.substring(1);
        rec(S,x);
        Collections.sort(ans);
        return ans;
    }
    
}