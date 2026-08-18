class MinStack {
    long min;
    Stack<Long> stack = new Stack<>();

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()) min = val;
         
        long diff = val - min;
        if(val < min) min = val;
        stack.push(diff);

    }
    
    public void pop() {
        long top = stack.pop();
        if(top < 0){
            min = min - top;
        }
    }
    
    public int top() {
        long top = stack.peek();
        if(top > 0){
            return (int) (top + min);
        }
        return (int) min;

    }
    
    public int getMin() {
        return (int) min;
    }
}

// 16:36

// 10m

// using a track of min upto the point using another stack

// uisng one stace storing the diff
