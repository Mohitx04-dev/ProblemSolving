class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int c = 0;
        int cur = nums[0];
        for(int x : nums) {
            if(cur==x) {
                c++;
            }
            else {
                cur = x;
            }
            if(c>nums.length/2){
                return x;
            }
        }
        return 0;
    }
}