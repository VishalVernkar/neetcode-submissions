class MyCircularQueue {
    private class Node{
        int val;
        Node next;

        private Node(int val){
            this.val = val;
        }
    }

    Node front;
    Node rear;
    int size;

    public MyCircularQueue(int k) {
        front = new Node(0);
        rear = front;
        size = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        // insert from rear
        Node node = new Node(value);
        this.rear.next = node;
        this.rear = node;
        size--;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;

        this.front.next = this.front.next.next;
        if(this.front.next == null) this.rear = this.front;
        size++;
        return true;
    }
    
    public int Front() {
        return (isEmpty())? -1 : this.front.next.val;
    }
    
    public int Rear() {
        return (isEmpty())? -1 : this.rear.val;
    }
    
    public boolean isEmpty() {
        return this.front.next == null;
    }
    
    public boolean isFull() {
        return this.size == 0;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */