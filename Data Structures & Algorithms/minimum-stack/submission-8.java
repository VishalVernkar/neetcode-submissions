class MinStack {

    Stack<Long> stack;
    int minVal;

    public MinStack() {
        stack = new Stack<>();
        minVal = 0;
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
            stack.push(0L);
            minVal = val; 
        } else {
            stack.push((long)val - minVal);
            if(val < minVal){
                minVal = val;
            }
        }
    }
    
    public void pop() {
        Long val = stack.pop();
        if(val < 0){
            minVal = (int) (minVal - val);
        } 
    }
    
    public int top() {
        Long val = stack.peek();
        int res = 0;
        if(val < 0){
            res = (int) minVal;
        } else {
            res = (int) (val + minVal);
        }

        return res;
    }
    
    public int getMin() {
        return minVal;
    }
}
