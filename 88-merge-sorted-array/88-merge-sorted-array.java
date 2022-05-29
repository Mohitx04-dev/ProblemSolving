class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0; i<m; i++) {
            if(n>0){
            if(nums1[i]>nums2[0]) {
                int temp = nums1[i];
                nums1[i] = nums2[0];
                nums2[0] = temp;
                Arrays.sort(nums2);
            } 
            }
        }
        if(n>0){
        for(int i=m; i<m+n; i++) {
            nums1[i] = nums2[i-m];
        }
        }
    }
}