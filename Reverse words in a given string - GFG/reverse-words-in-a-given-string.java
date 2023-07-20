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
        StringBuilder sb = new StringBuilder();
        Stack<String> st = new Stack<String>();
        int p = 0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='.') {
                st.push(S.substring(p,i));
                p=i+1;
            }
        }
        st.push(S.substring(p,S.length()));
        while(!st.isEmpty()) {
            sb.append(st.pop());
            if(st.size()>0) sb.append(".");
        }
        return new String(sb);
    }
}