//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        long s = 1; 
        long a = -(int)1e9;
        for(int i=0;i<arr.length;i++) {
            s = s * arr[i];
            a = Math.max(a,s);
            if(s==0) s = 1;
        }
        s=1;
        for(int i=arr.length-1;i>=0;i--) {
            s = s * arr[i];
            a = Math.max(a,s);
            if(s==0) s = 1;
        }
        return a;
    }
}