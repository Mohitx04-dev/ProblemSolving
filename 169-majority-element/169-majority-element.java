class Solution {
    public int majorityElement(int[] nums) {
        int c = 0;
        int cur = nums[0];
        for(int x : nums) {
             if(c==0) {
                cur = x;
            }
            if(cur==x) {
                c++;
            }
            else {
                c--;
            }
        }
        return cur;
    }
}