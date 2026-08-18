class StockSpanner {

    Stack<int []> prices; // storing in ascending orders

    public StockSpanner() {
        prices = new Stack<>();
    }
    
    public int next(int price) {
        int consDays = 1;
        while(!prices.isEmpty() && prices.peek()[0] <= price){
            int[] pair = prices.pop();
            consDays+=pair[1];
        }
        prices.push(new int[]{price, consDays});
        return consDays; 
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

 // for the current price I have to get the number of consecutive days where price is <= cureent price 
 // [100, 80, 60, 70, 60, 75, 85]

 // Hint: stack
 // Brute force - n^2
 // taking each element counting its previous consecutive days where prices[i] <= currentPrice
 
//    0   1   2   3   4   5   6
 // [100, 80, 60, 70, 60, 75, 85]
 //   1    1   1   2   1   4   6

 // I can use a stack to only keep bigger elements over small ones
 // I can store index, so that I can access result window
 // or
 // stack to store key, value pairs
 // I can store values along with its consecutive days, i don't need all values so index is not necessary

 // is there any other approaches