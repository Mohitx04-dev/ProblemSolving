//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-->0){
            String s1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[9][9];
            for(int i = 0;i < 81;i++)
                mat[i/9][i%9] = Integer.parseInt(s1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.isValid(mat));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

public class Solution {
	static boolean checkRows(int r, int[][]matrix) {
		int[]vis = new int[10];
		for(int i=0;i<9;i++) {
			if(matrix[r][i]!=0) {
			if(vis[matrix[r][i]]==1) return false;
			else vis[matrix[r][i]]=1;
			}
		}
// 		System.out.println(Arrays.toString(vis));
		return true;
	}
	static boolean checkCols(int c, int[][] matrix) {
		int[]vis = new int[10];
		for(int i=0;i<9;i++) {
			if(matrix[i][c]!=0) {
			if(vis[matrix[i][c]]==1) return false;
			else vis[matrix[i][c]]=1;
			}
		}
		return true;
	}
	static boolean checkInnerSquare(int i,int j, int[][]matrix) {
		int[]vis = new int[10];
		for(int x=i;x<i+3;x++) {
			for(int y=j; y<j+3;y++) {
				if(matrix[x][y]!=0) {
				if(vis[matrix[x][y]]==1) return false;
				else vis[matrix[x][y]]=1;
				}
			}
		}
		return true;
	}
	public static int isValid(int matrix[][]) {

		// Write your code here.
		boolean tt = true;	
		for(int i=0;i<9;i++) {
			tt = tt & checkRows(i,matrix);
			tt = tt & checkCols(i,matrix);
		}
		tt = tt &  checkInnerSquare(0,0,matrix);
		tt = tt &  checkInnerSquare(0,3,matrix);
		tt =  tt & checkInnerSquare(0,6,matrix);
		tt = tt & checkInnerSquare(3,0,matrix);
		tt = tt & checkInnerSquare(6,0,matrix);
		tt = tt & checkInnerSquare(3,3,matrix);
		tt = tt & checkInnerSquare(6,6,matrix);
		tt = tt & checkInnerSquare(3,6,matrix);
		tt = tt & checkInnerSquare(6,3,matrix);
		if(tt) return 1;
		else return 0;
	}
}
