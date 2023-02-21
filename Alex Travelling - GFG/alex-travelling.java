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
            int k = sc.nextInt();

            int tmp = sc.nextInt();
            int[][] flights = new int[tmp][3];
            for (int i = 0; i < tmp; i++) {

                int u1 = sc.nextInt();
                int v1 = sc.nextInt();
                int w1 = sc.nextInt();
                flights[i][0] = u1;
                flights[i][1] = v1;
                flights[i][2] = w1;
            }

            Solution ob = new Solution();
            int ans = ob.minimumCost(flights, n, k);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int minimumCost(int[][] flights, int n, int k) {
        // Your code here
        ArrayList<ArrayList<int[]>> adj = new ArrayList<ArrayList<int[]>>();
        for(int i=0; i<n+1; i++) adj.add(new ArrayList<int[]>());
        for(int[] fl : flights) adj.get(fl[0]).add(new int[]{fl[1],fl[2]});
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((int[]p, int[]q)->p[1]-q[1]);
        pq.add(new int[]{k,0});
        int[]time = new int[n+1];
        Arrays.fill(time,(int)1e9);
        time[k]=0;
        while(!pq.isEmpty() || n!=0) {
            int[] fl = pq.poll();
            n--;
            if(fl==null) break;
            for(int[] t : adj.get(fl[0])) {
                if(time[t[0]]> t[1] + fl[1]) {
                    time[t[0]] = t[1] + fl[1];
                    pq.add(new int[]{t[0],time[t[0]]});
                }
            }
        }
        int ans=-1;
        for(int i=1;i<time.length;i++) {
            if(time[i] == (int)1e9) return -1;
            ans = Math.max(ans, time[i]);
        }
        return ans;
    }
}
