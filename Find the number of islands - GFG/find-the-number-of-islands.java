//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
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
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int r = grid.length; 
        int c = grid[0].length;
        DisjointSet d = new DisjointSet(r*c);
        for(int i=0;i<r;i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j]=='1') {
                    for(int x=i-1; x<=i+1; x++){
                        for(int y=j-1; y<=j+1; y++) {
                            if(x<0 || y<0 || x>=r || y>=c) continue;
                            if(grid[x][y]=='1') d.Union((x*c) + y, (i*c) + j);
                        }
                    }
                }
                if(grid[i][j]=='0') d.p[i*c + j] = -1;
            }
        }
        int ans = 0;
        for(int i=0;i<(r*c); i++) {
            if(d.p[i]==i) ans++;
        }
        return ans;
    }
}