class Solution {
    int[][] swap(int[][]arr, int x2,int y2, int x1, int y1 ){
        int temp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = temp;
        for(int i=0; i<arr.length; i++){
            for(int x : arr[i]) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        System.out.println("------");
        return arr;
    }
    
    public void rotate(int[][] arr) {
        int n = arr.length;
        for(int k=0; k<n/2; k++) {
            System.out.println("k = " + k);
            for(int j=0; j<n-(2*k)-1; j++){
                System.out.println( (j+(2*k)) + " , "+ (n-1) + " -> " + 0 + " , " + (j+(2*k)) );
                System.out.println(0 + " , " + (j+(2*k)) + " -> " + (n-1-j-(2*k)) + " , " +0);
                System.out.println( (n-1-j-(2*k)) + " , " + 0 + " -> " + (n-1) + " , " + (n-j-1-(2*k)));
                    arr = swap(arr,j+(k),n-1-k,k,j+(k));
                    arr = swap(arr,k,j+(k), n-1-j-(k), k);
                    arr = swap(arr,n-j-1-(k),k,n-1-k,n-j-1-(k));
            }
        }
    }
}