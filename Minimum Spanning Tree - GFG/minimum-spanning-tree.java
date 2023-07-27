//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java
class UF {
    int[] parent;
    int[] size;
    public UF(int n) {
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findParent(int i){
        if(parent[i] == i) return i;
        else return findParent(parent[i]);
    }
    public void union(int i, int j) {
        i = findParent(i);
        j = findParent(j);
        if(i!=j) {
            if(size[i]>=size[j]) {
                size[i]+=size[j];
                parent[j] = i;
            }else {
                size[j]+=size[i];
                parent[i] = j;
            }
        }
    }
}
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    Arrays.sort(edges,(a,b)->(a[2]-b[2]));
	    int cost = 0;
	    UF uf = new UF(V);
	    for(int[] e : edges) {
	        if(uf.findParent(e[0])!=uf.findParent(e[1])) {
	             uf.union(e[0],e[1]);
	             cost+=e[2];
	        }
	    }
	    return cost;
	}
}