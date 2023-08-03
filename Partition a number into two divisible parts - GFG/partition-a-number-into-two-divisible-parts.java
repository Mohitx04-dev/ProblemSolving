//{ Driver Code Starts
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
            String str[] = read.readLine().split(" ");
            String S= str[0];
            int a = Integer.parseInt(str[1]);
            int b = Integer.parseInt(str[2]);
            Solution ob = new Solution();
            System.out.println(ob.stringPartition(S,a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static String stringPartition(String S, int a, int b){
        // code here
        
        for(int i=0;i<S.length()-1;i++) {
            String x = S.substring(0,i+1);
            String y = S.substring(i+1,S.length());
            if(Integer.parseInt(x)%a==0 && Integer.parseInt(y)%b==0) return x+" "+y;
        }
        return "-1";
    }
}