//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    static int countPaths(int n, List<List<Integer>> roads) {
        // Your code here
        ArrayList<ArrayList<int[]>> adj = new ArrayList<ArrayList<int[]>>();
        int mod = (int)1e9+7;
        for(int i=0; i<n; i++) adj.add(new ArrayList<int[]>());
        for(List<Integer> fl : roads) {
            adj.get(fl.get(0)).add(new int[]{fl.get(1),fl.get(2)});
            adj.get(fl.get(1)).add(new int[]{fl.get(0),fl.get(2)});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((int[]p, int[]q)->p[1]-q[1]);
        pq.add(new int[]{0,0});
        int[]time = new int[n];
        int[]ways = new int[n];
        Arrays.fill(time,Integer.MAX_VALUE);
        time[0]=0;
        ways[0]=1;
        while(!pq.isEmpty()) {
            int[] fl = pq.poll();
            for(int[] t : adj.get(fl[0])) {
                if(time[t[0]]>t[1]+fl[1]) {
                    ways[t[0]] = ways[fl[0]];
                    time[t[0]] = t[1] + fl[1];
                    pq.add(new int[]{t[0],time[t[0]]});
                }
                else if(time[t[0]]==t[1]+fl[1]){
                     ways[t[0]] = (ways[t[0]] + ways[fl[0]])%mod;
                }
            }
        }
        return ways[n-1]%mod;
    }
}
