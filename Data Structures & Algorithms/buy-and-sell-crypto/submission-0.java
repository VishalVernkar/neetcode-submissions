class Solution {
    public int maxProfit(int[] prices) {
        int l=0;
        int profit =0;
        for(int r=0;r < prices.length;r++){
            if(prices[r]>prices[l]){
                profit = Math.max(prices[r] - prices[l], profit);
            } else {
                l=r;
            }
        }
        return profit;
    }
}
