//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static List<Integer> shortestPath(int V, int m, int edges[][]) {
        // code here
        int[] dist = new int[V+1];
        Arrays.fill(dist,(int)1e9);
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        for(int i=0; i<=V; i++) adj.add(new ArrayList<ArrayList<Integer>>());
        for(int[] edge : edges) {
            ArrayList<Integer> tempp = new ArrayList<Integer>();
            ArrayList<Integer> tempp2 = new ArrayList<Integer>();
            tempp.add(edge[1]);
            tempp.add(edge[2]);
            tempp2.add(edge[0]);
            tempp2.add(edge[2]);
            adj.get(edge[0]).add(tempp);
            adj.get(edge[1]).add(tempp2);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((int[] a, int[] b)->{
            if(a[1]<b[1]) return -1;
            else if(a[1]>b[1]) return 1;
            else if(a[0]<b[0]) return -1;
            else return 1;
        });
        List<Integer> ans = new ArrayList<Integer>();
        pq.add(new int[]{1,0});
        dist[1] = 0;
        int[] parent = new int[V+1];
        while(!pq.isEmpty()) {
            int[] t = pq.poll();
            if(t[1]>dist[t[0]]) continue;
            for(ArrayList<Integer> x : adj.get(t[0])) {
                if(x.get(1)+ dist[t[0]] < dist[x.get(0)]) {
                    dist[x.get(0)] = x.get(1) + t[1];
                    pq.add(new int[] {x.get(0), dist[x.get(0)]});  
                    parent[x.get(0)] = t[0];
                }
            }
        }
        ans.add(V);
        int p = parent[V];
        while(p!=0) {
            ans.add(p);
            p = parent[p];
        }
        if(!ans.contains(1)) {
            ans.clear();
            ans.add(-1);
            return ans;
        }
        Collections.reverse(ans);
        return ans;
    }
}