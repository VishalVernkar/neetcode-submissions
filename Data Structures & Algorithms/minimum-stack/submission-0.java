class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    // I can use two stack to store the elements in Descending order
    // but how will I know which element being removed
    // can I use indices? and store it based on the thier values in descending order 
    // storing will take O(n) - amortized
    // pop() - removing will take O(n) - always

    // use other data structure?
    // deque
    // Arrays + pointers?

    // problem is how do keep track of min
    // I need to keep it in order in another ds
    // whenever a element is popped
    // I've to check and remove it here in this ds

    // 2 3 5 4 1 6
    // 5 4 3 2 1 

    // prefix
    // 2 2 2 2 1 6

    // how O(1) possible?

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()){
            minStack.push(val);
        } else {
            minStack.push(Math.min(minStack.peek(),val));
        }
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
    
}
