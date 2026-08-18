class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        int size = q.size();
        q.offer(x);
        while(size > 0){
            q.offer(q.poll());
            size--;
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

 // LIFO
//  1 2 3 4
// 1
// q.offer(q.poll())
// 1 
// we insert - we reverse?
// 1 2 3 4
// 4 3 2 1
// 4 3 2 1

// 1 2 3 4
// 2 3 4 1
// 3 4 1 2






// 1
// 1 2

// 2 1

// 2 1 3
// 3 1 2




// how to revrse?
// 1
// 2
// 1 2 -> 2 1
// 3
// 2 1 3 -> 1 3 2

// 1 2
// 2 1
// 2 1 3
// 3 2 1