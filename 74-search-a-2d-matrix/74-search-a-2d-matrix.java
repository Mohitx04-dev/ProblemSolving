class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int k=0;
        if(matrix.length==1){
            for(int i=0; i<matrix[0].length; i++) {
                if(matrix[0][i]==target) {
                    return true;
                }
            }
        }
        for(int i=0; i<matrix.length-1; i++)
        {
            if(target<matrix[i+1][0] && target>=matrix[i][0]) {
                for(int j=0; j<matrix[i].length; j++){
                    if(target==matrix[i][j]){
                        return true;
                    }
                }
            }
        }
           for(int i=0; i<matrix[matrix.length-1].length; i++) {
                if(matrix[matrix.length-1][i]==target) {
                    return true;
                }
            }
        return false;
    }
}