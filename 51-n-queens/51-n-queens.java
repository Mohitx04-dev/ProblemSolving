import java.util.*;
public class Solution {
    static boolean[] leftRow;
    static boolean[] upperDiag;
    static boolean[] lowerDiag;
    static int count=0;
    static void NQueenBoard(int col, boolean[][] board, List<List<String>> ans, int n) {
        if(col==n){
            count++;
            List<String> list = new ArrayList<>();
            for(int i=0;i<n;i++) {
                String str="";
                for(int j=0; j<n; j++) {
                    if(board[i][j]) str+='Q';
                    else str+='.';
                }
                list.add(str);
            }
            ans.add(list);
            return;
        } 
            for(int row=0; row<n; row++) {
                if(!leftRow[row] && !lowerDiag[row+col] && !upperDiag[n - 1 + col - row]){
                    board[row][col]=true;
                    leftRow[row]=true;
                    lowerDiag[row+col]=true;
                    upperDiag[n - 1 +col - row]=true;
                    NQueenBoard(col+1,board,ans,n);
                    board[row][col]=false;
                    leftRow[row]=false;
                    lowerDiag[row+col]=false;
                    upperDiag[n - 1 +col - row]=false;
                }
            }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        ans = new ArrayList<>();
        leftRow = new boolean[n];
        upperDiag = new boolean[2*n-1];
        lowerDiag = new boolean[2*n-1];
        NQueenBoard(0, board,ans,n);
        return ans;
    }
}
