class Solution {
    public int[] sortedSquares(int[] nums) {
        int first = 0;
        int last = nums.length-1;
        int idx = nums.length-1;
        int[] ans = new int[nums.length];
        while(first<=last) {
            if(Math.abs(nums[first])>Math.abs(nums[last])) {
                ans[idx]=nums[first]*nums[first];
                first++;
            }
            else{
                ans[idx]=nums[last]*nums[last];
                last--;
            }
            idx--;
        }
        return ans;
    }
}