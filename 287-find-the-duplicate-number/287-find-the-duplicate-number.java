class Solution {
    public int findDuplicate(int[] nums) {
       int n = nums.length-1;
       int[] x = new int[n+1];
       for(int i=0; i<n+1; i++){
            x[nums[i]]++;
       }
       
       for(int i=0; i<n+1; i++) {
           if(x[i]>1){
               return i;
           }
       }
        return 0;
    }
}