class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;
        int minPrice = prices[0];
        for(int i = 0; i < n; i++){
            if(prices[i] > minPrice){
                profit = Math.max(profit, prices[i] - minPrice);
            }
            minPrice = Math.min(minPrice, prices[i]);
        }
        return profit;
    }
}

// brute force
// buy at min - sell at max future price
// from left - min so far
// from right - max so far
// 
