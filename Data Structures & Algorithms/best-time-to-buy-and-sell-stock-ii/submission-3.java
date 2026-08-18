class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length - 1;
        int boughtPrice = -1; // not bought
        int i=0;
        for(;i<n;i++){
            //cur = prices[i];
            if(boughtPrice==-1 && prices[i]<prices[i+1]){ // buy
                boughtPrice = prices[i];
            } else if(boughtPrice!=-1 && prices[i] > boughtPrice){ //sell
                while(i < n && prices[i] < prices[i+1]){
                    i++;
                }
                profit+= prices[i] - boughtPrice;
                boughtPrice = -1;
            }
        }

        if( i==n && boughtPrice!=-1 && prices[n] > boughtPrice){
            profit+= prices[n] - boughtPrice;
        }
        return profit;
    }
}