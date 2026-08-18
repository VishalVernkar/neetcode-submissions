class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxProfit = 0;
        for(int r = 0; r < prices.length; r++){
            if(prices[r] < minBuy){
                minBuy = prices[r];
            } else {
                maxProfit = Math.max(maxProfit, prices[r] - minBuy);
            }
        }
        return maxProfit;
    }
}
