class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int f = 0;
        int l = numbers.length-1;
        int []ans = new int[2];
        while(f<l) {
            if(numbers[f]+numbers[l]==target){
                ans[0] = f+1;
                ans[1] = l+1;
                return ans;
            }
            else if(numbers[f]+numbers[l]<target){
                f++;
            }
            else {
                l--;
            }
        }
        return ans;
    }
}