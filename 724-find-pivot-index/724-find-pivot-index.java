class Solution {
    int sum(int[] nums, int i, int j) {
        int s=0;
        for(int k=i; k<=j; k++){
            s+=nums[k];
        }
        return s;
    }
    public int pivotIndex(int[] nums) {
        int ptr=0; 
        while(ptr<=nums.length-1) {
            if(sum(nums,0,ptr-1)==sum(nums,ptr+1,nums.length-1)) return ptr;
            ptr++;
        }
        return -1;
    }
}