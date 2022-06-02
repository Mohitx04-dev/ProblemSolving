class Solution {
    public int[][] transpose(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] ans = new int[m][n];
        int c = 0;
        for(int [] x : matrix) {
            for(int i=0; i<x.length; i++) {
                ans[i][c] = x[i]; 
            }
            c++;
        }
        return ans;
    }
}