class Solution {
    public void moveZeroes(int[] nums) {
       int c=0;
       for(int i=0; i<nums.length; i++) {
           if(nums[i]!=0) {
               int t = nums[i];
               nums[i]=nums[c];
               nums[c] = t;
               c++;
           }
       }
    }
}