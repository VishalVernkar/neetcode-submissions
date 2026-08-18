class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = prices[0];
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - minPrice);
            }
            // profit = Math.max(profit, prices[i] - minPrice);
            // minPrice = Math.min(minPrice, prices[i]);
        }
        return profit;
    }
}

// 10:59


// buying at min and selling at max is same as -> buying and selling on increases price - adding each of them gives same res

// sliding window problem
// when to buy 
// when to sell
// 

// brute force
// from each price -> its max from that point
// max among all of these
// 

// simplify
// current min price 
// track current min price -> get all the max profit from there


