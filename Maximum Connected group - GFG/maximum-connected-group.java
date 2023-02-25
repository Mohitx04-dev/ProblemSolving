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
            int[][] grid = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            
            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class DisjointSet {
    int[] p;
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
    public int MaxConnection(int[][] grid) {
        int r = grid.length; 
        int c = grid[0].length;
        DisjointSet d = new DisjointSet(r*c);
        int total=0;
        for(int i=0;i<r;i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j]==1) {
                    for(int x=i-1; x<=i+1; x++){
                        for(int y=j-1; y<=j+1; y++) {
                              if(x==i && y==j) continue;
                            if(x!=i && y!=j) continue;
                            if(x<0 || y<0 || x>=r || y>=c) continue;
                            if(grid[x][y]==1) d.Union((x*c) + y, (i*c) + j);
                        }
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i : d.size) max = Math.max(i,max);
        for(int k : d.p) {
            int i = k/r;
            int j = k%r;
            HashSet<Integer> hs = new HashSet<Integer>();
            if(grid[i][j]==0){
                for(int x=i-1; x<=i+1; x++){
                        for(int y=j-1; y<=j+1; y++) {
                            if(x==i && y==j) continue;
                            if(x!=i && y!=j) continue;
                            if(x<0 || y<0 || x>=r || y>=c) continue;
                            if(grid[x][y]==1) hs.add(d.findParent(x*c + y));
                        }
                }
            }
            int num=0;
            for(int t : hs) num+=d.size[t];
            max = Math.max(max,num+1);
        }
        return max;
    }
}