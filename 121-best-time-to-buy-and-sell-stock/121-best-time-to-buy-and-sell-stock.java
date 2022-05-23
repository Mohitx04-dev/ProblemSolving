class Solution {
    public int maxProfit(int[] prices) {
        ArrayList<Integer> x = new ArrayList<Integer>();
        int i=0;
        while(i<prices.length-1){
            x.add(prices[i+1]-prices[i]);
            i++;
        }
        int maxSum = 0;
        int curSum = 0;
        for(int y : x) {
            curSum += y;
            if(curSum>maxSum) {
                maxSum = curSum;
            }
            if(curSum<0) {
                curSum = 0;
            }
        }
        return maxSum;
    }
}