class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.offer(x);
        int i = 0;
        while(i < q.size() - 1){
            q.offer(q.poll());
            i++;
        }
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

 // 1 2
//  2 1
//  2 1 3
//  3 2 1

//  3 2 1 4
//  4 3 2 1

 // reverse at every insertion
 // the rder is preserve and 