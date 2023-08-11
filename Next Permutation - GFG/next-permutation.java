//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static void swap(int i, int j, int[]arr) {
                        int t = arr[j];
                        arr[j] = arr[i];
                        arr[i] = t;
    }
    static List<Integer> nextPermutation(int N, int arr[]){
        // code here
        boolean found = false;
        loop : for(int i=N-2;i>=0;i--) {
            if(arr[i] < arr[i+1]) {
                for(int j=N-1;j>=i;j--) {
                    if(arr[j] > arr[i]) {
                        swap(i,j,arr);
                        int a = i+1;
                        int b = N-1;
                        while(a<b) swap(a++,b--,arr);
                        found = true;
                        break loop;
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        if(!found) {
            for(int i=N-1;i>=0;i--) ans.add(arr[i]);
        }
        else for(int i=0; i<N;i++) ans.add(arr[i]);
        return ans;
    }
}