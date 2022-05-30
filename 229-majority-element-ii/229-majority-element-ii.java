class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Arrays.sort(nums);
        int c = 0;
        int cur = nums[0];
        List<Integer> ans = new ArrayList<Integer>();
        for(int x : nums) {
            if(ans.contains(x)){
                continue;
            }
            if(cur==x){
                c++;
            }
            else{
                c=1;
                cur = x;
            }
            if(c>nums.length/3){
                ans.add(x);
            }
        }
        return ans;
        
    }
}