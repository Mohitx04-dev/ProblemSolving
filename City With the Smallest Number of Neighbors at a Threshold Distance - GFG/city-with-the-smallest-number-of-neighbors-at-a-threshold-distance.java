//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] adj = new int[m][3];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < 3; j++) {
                    adj[i][j] = sc.nextInt();
                }
            }

            int dist = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.findCity(n, m, adj, dist);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
      int findCity(int n, int m, int[][] edges,int distanceThreshold)
      {
          //code here
             int[][] mat = new int[n][n];
       for(int [] e : edges){ 
           mat[e[0]][e[1]] = e[2];
           mat[e[1]][e[0]] = e[2];
       }
       for(int i=0;i<mat.length;i++) {
            for(int j=0; j<mat.length;j++) {
                if(i==j) mat[i][j] = 0;
                else if(mat[i][j]==0) mat[i][j] = (int)1e9;
            }
        }
        for(int i=0; i<mat.length; i++) {
            for(int j=0; j<mat.length; j++) {
                for(int k=0; k<mat.length; k++) {
                    if(mat[j][k] > mat[j][i] + mat[i][k]) mat[j][k] = mat[j][i] + mat[i][k];
                }
            }
        }
        int ans = n;
        int node = 0;
         for(int i=0;i<mat.length;i++) {
            int x = 0;
            for(int j=0; j<mat.length;j++) {
                if(i==j) mat[i][j] = 0;
                else if(mat[i][j]==(int)1e9) mat[i][j] = -1;
                else if(mat[i][j]<=distanceThreshold) x++;
            }
            ans = Math.min(ans,x);
            if(ans == x) node = i;
        }  
        return node;
      }
      
}
