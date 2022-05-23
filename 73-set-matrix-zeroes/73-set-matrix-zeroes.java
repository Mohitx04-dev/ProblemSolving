class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        for(int i=0; i<n; i++) {
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    arr1.add(i);
                    arr2.add(j);
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr1.contains(i) || arr2.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }
    }
}