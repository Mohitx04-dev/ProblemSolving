class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int prod = 1;
        int ext = 0;
        boolean pr = false;
        int c=0;
        for(int x : nums) {
            if(x==0) {
                pr = true;
                c++;
                if(c>1) return ans;
            }
            else {
                prod*=x;
            }
        } 
        if(pr) {
            ext = prod;
            prod = 0;
        }
        for(int i=0; i<nums.length;i++) {
           if(nums[i]==0) ans[i]=ext;
           else ans[i] = (prod)/nums[i];
        }
        return ans;
    }
}