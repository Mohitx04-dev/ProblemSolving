//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        // code here 
        Stack<String> st = new Stack<String>();
        for(String t : S.split("\\.")) st.push(t);
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
            if(st.size()>=1) sb.append(".");
        }
        return new String(sb);
    }
}