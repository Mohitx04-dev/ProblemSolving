class Solution {
    public int search(int[] nums, int target) {
        return binSearch(0,nums.length-1,nums,target); 
    }
    public int binSearch(int s,int e,int[] nums,int t){
        int m=(s+e)/2;
        if(s>e){
            return -1;
        }
        if(nums[m]==t){
            return m;
        }
       else if(t<nums[m]){
            return binSearch(s,m-1,nums,t);
        }
        else{
            return binSearch(m+1,e,nums,t);
        }
       
    }
}