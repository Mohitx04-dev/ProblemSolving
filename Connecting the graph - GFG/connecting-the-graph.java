//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


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
}class Solution {
    public int Solve(int n, int[][] connections) {
        DisjointSet d = new DisjointSet(n);
        int extra = 0;
        int comp = 0;
        for(int[] e : connections) {
            if(d.findParent(e[0])!=d.findParent(e[1])) {
                d.Union(e[0],e[1]);
            }
            else extra++;
        }
        for(int i=0;i<n;i++){
            if(d.p[i]==i) comp++;
        }
        if(extra>=comp-1) return comp-1;
        else return -1;
    }
}