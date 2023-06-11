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
    int findParent(int i) {
        if(parent[i]==i) return i;
        else return findParent(parent[i]);
    }
    void union(int i, int j) {
        i = findParent(i);
        j = findParent(j);
        if(i==j) return;
        if(size[i] >= size[j]) {
            size[i]++;
            parent[j] = i;
        }
        else {
            size[j]++;
            parent[i] = j;
        }
    }
}
class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        UF uf = new UF(n*m);
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]=='1') {
                    for(int x = i-1; x<=i+1; x++) {
                        for(int y=j-1; y<=j+1; y++) {
                            if(x<0||y<0||x>=n||y>=m||(x==i&&y==j)||grid[x][y]=='0') continue;
                            uf.union(m*i+j,m*x+y);
                        }
                    }
                }
                else uf.parent[m*i + j]  = -1;
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(uf.parent[m*i + j]==(m*i + j)) ans++;
            }
        }
        return ans;
    }
}