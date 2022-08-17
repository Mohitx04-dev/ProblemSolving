class Solution {
    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        int prevSum=0;
        for(int i=0; i<nums.length; i++) {
            int sum=prevSum;
            sum+=nums[i];
            prevSum = sum;
            ans[i]=sum;
        }
        return ans;
    }
}