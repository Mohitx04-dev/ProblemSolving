class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2 ; i++) {
            if(i==0 || (i>0 && nums[i]!=nums[i-1]) && nums[i]<=0) {
            int f = i+1;
            int l = nums.length-1;
            while(l>f) {
                if(nums[f]+nums[l]>-nums[i]) l--;  
                else if(nums[f]+nums[l]+nums[i]==0){
                      list.add(Arrays.asList(nums[i],nums[f],nums[l]));
                      while(l>f && nums[f+1]==nums[f]) f++;
                      while(l>f && nums[l-1]==nums[l]) l--;
                    f++;
                    l--;
                 }
                else f++;
            }
            }
        }
        return list;
    }
}