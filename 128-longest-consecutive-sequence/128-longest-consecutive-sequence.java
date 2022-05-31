class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==1){
            return 1;
        }
        Arrays.sort(nums);
        int max=0;
        int c=1;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i+1]==nums[i]+1 || nums[i+1]==nums[i]-1){
                c++;
            }
            else if(nums[i]==nums[i+1]){
                c+=0;
            }
            else{
                c=1;
            }
            if(c>max){
                max=c;
            }
            System.out.println(nums[i] + " " + c + " " + max);
        }
        return max;
    }
}