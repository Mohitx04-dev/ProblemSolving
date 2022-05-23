class Solution {
    public void sortColors(int[] nums) {
        int red = 0; 
        int white = 0;
        int blue = 0;
        for(int x : nums){
            if(x==0){
                red++;
            }
            if(x==1){
                white++;
            }
            if(x==2){
                blue++;
            }
        }
      int i=0;
      while(i<nums.length) {
           if(red>0)
           {
              while(red!=0){
                nums[i]=0;
                i++;
                red--;
            }  
           }
          else if(white>0){
            while(white!=0){
                nums[i]=1;
                i++;
                white--;
            }
          } else if(blue>0) {
            while(blue!=0){
                nums[i]=2;
                i++;
                blue--;
            }
          }
        }
    }
}