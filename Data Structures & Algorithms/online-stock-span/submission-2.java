class StockSpanner {
    Deque<Integer> stack;
    Deque<Integer> span;

    public StockSpanner() {
        stack = new ArrayDeque<>();
        span = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int spanTotal = 1;
        while(!stack.isEmpty() && stack.peek() <= price){
            stack.pop();
            spanTotal += span.pop();
        }
        stack.push(price);
        span.push(spanTotal);

        return span.peek();
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

 // 11:20 - 11:40

 // we can use stack for this
 // we pop if next element is bigger

 // we may need two stack or one stack that tracks  its number of elment less than itself
 // 