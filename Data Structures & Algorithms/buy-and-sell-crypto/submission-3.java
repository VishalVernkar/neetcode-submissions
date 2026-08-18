class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int profit = 0;
        int  l = 0;
        int  r = 1;
        while(r<n){
            if(prices[l] < prices[r]) {
                profit = Math.max(profit, prices[r] - prices[l]);
            } else {
                l = r;
            }
            r++;
        }
        return profit;
    }
}


// I can use the same approach I did in arrays module

// okay I need to sell only one time and get profit

// brute force
// take each and if greater comes get profit -> track max

// hint slidind window
// how is this a sliding window problem

// what do I need?
// I need to find the min price from left and sell it at highest price in future 
// is it expanding window or two pointers?