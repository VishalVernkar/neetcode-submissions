class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()) minStack.push(val);
        else minStack.push(Math.min(minStack.peek(), val));
    }
    
    public void pop() {
        minStack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

// 6:10 - 20 min

// Question
// getMin -> should give min in the stack

// I can use a one more stack to track the min elements
// If I pop that element I should also pop it from min stack?

// using another stack to trak
// we push only if it is smaller


// 1 2 0
// 2 1 0

// pre min
// 1 1 0
// yes this works




// does deques helps?
