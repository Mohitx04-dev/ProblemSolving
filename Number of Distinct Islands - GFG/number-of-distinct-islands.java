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
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean[][] vis;
    static void dfs(int i, int j, int ip, int jp, int[][] grid, ArrayList<ArrayList<Integer>> list) {
        int m = grid.length;
        int n = grid[0].length;
        if(i<0 || i>m-1 || j<0 || j>n-1 || grid[i][j]==0 || vis[i][j]) {
            return;
        }
        vis[i][j] = true;
        ArrayList<Integer> t = new ArrayList<Integer>();
        t.add(i-ip);
        t.add(j-jp);
        list.add(t);
        dfs(i,j-1,ip,jp,grid,list);
        dfs(i,j+1,ip,jp,grid,list);
        dfs(i+1,j,ip,jp,grid,list);
        dfs(i-1,j,ip,jp,grid,list);
    }
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        HashSet<ArrayList<ArrayList<Integer>>> hs = new HashSet<ArrayList<ArrayList<Integer>>>();
        int m = grid.length;
        int n = grid[0].length;
        vis = new boolean[m][n];
        for(int i=0;i<m;i++) {
            for(int j=0; j<n; j++) {
                if(!vis[i][j] && grid[i][j]==1) {
                     ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
                     dfs(i,j,i,j,grid,list);
                     hs.add(list);
                }
            }
        }
        return hs.size();
    }
}
