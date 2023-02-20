//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int[] dist = new int[V];
        Arrays.fill(dist,(int)1e9);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((int[] a, int[] b)->{
            if(a[1]<b[1]) return -1;
            else if(a[1]>b[1]) return 1;
            else if(a[0]<b[0]) return -1;
            else return 1;
        });
        pq.add(new int[]{S,0});
        dist[S] = 0;
        while(!pq.isEmpty()) {
            int[] t = pq.poll();
            for(ArrayList<Integer> x : adj.get(t[0])) {
                if(x.get(1)+ dist[t[0]] < dist[x.get(0)]) {
                    dist[x.get(0)] = x.get(1) + t[1];
                    pq.add(new int[] {x.get(0), dist[x.get(0)]});   
                }
            }
        }
        return dist;
    }
}

