class Solution {
    int[][] swap(int[][]arr, int x2,int y2, int x1, int y1 ){
        int temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
        return arr;
    }
    
    public void rotate(int[][] arr) {
        int n = arr.length;
        for(int k=0; k<n/2; k++) {
            System.out.println("k = " + k);
            for(int j=0; j<n-(2*k)-1; j++){
                    arr = swap(arr,j+(k),n-1-k,k,j+(k));
                    arr = swap(arr,k,j+(k), n-1-j-(k), k);
                    arr = swap(arr,n-j-1-(k),k,n-1-k,n-j-1-(k));
            }
        }
    }
}