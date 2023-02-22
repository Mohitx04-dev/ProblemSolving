//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        int mod = (int)1e5;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((int[]p, int[]q)->p[1]-q[1]);
        pq.add(new int[]{start,0});
        int[] vis = new int[mod+1];
        while(!pq.isEmpty()) {
            int[] st = pq.poll();
            if(st[0]==end) return st[1];
            for(int i : arr) {
                int el = (st[0]*i)%mod;
                if(vis[el]==1) continue;
                else vis[el] = 1;
                pq.add(new int[]{el,st[1]+1});
            }
        }
        return -1;
    }
}
