//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.isPerfectSquare(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static long isPerfectSquare(long n){
        // code here
        double x = Math.sqrt(n);
        int y = (int) x;
        if(x-y == 0) return 1;
        else return 0;
    }
}