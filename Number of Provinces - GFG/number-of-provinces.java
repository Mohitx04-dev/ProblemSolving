//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class DisjointSet {
    public int[] p;
    int[] size;
    public DisjointSet(int n){
        p = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++) p[i] = i;
        Arrays.fill(size,1);
    }
    public int findParent(int n) {
        if(p[n]==n) return n;
        else return p[n] = findParent(p[n]);
    }
    public void Union(int i, int j) {
        int a = findParent(i);
        int b = findParent(j);
        if(a==b) return;
        else if(size[a]>=size[b]) {
            size[a]+=size[b];
            p[b] = a;
        } 
        else {
            size[b]+=size[a];
            p[a] = b;
        }
    }
}
class Solution {
    
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        int n=1;
        DisjointSet d = new DisjointSet(V);
        for(int i=0;i<adj.size();i++) {
            for(int j=0; j<adj.size(); j++) {
                if(adj.get(i).get(j)==1) {
                   d.Union(i,j);
                }
            }
        }
        int ans = 0;
        for(int i=0;i<V;i++) {
            if(d.p[i] == i) ans++;
        }
        return ans;
    }
};