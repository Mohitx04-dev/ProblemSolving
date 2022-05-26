class Solution {
    public int[] finalPrices(int[] prices) {
        int[] ans = new int[prices.length];
        for(int i=0; i<prices.length; i++) {
            if(i==prices.length-1){
                ans[i]=prices[i];
                break;
            }
           inner : for(int j=i+1; j<prices.length; j++) {
               if(prices[i]>=prices[j]) {
                  ans[i]=prices[i]-prices[j];
                   break inner;
               }
               else{
                   ans[i]=prices[i];
               }
           }
        }
        return ans;
    }
}