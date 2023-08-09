//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int D = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minSteps(D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int minSteps(int target){
        // code here
       if(target<0) target = target*-1;
        int steps = 0;
        int s = 0;
        while(s<target){
            steps++;
            s+=steps;
        }
        while((s-target)%2!=0) {
            steps++;
            s+=steps;
        }
        return steps;
    }
}