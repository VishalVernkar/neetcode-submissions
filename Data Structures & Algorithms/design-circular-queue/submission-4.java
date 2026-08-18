class MyCircularQueue {
    private class ListNode{
        int val;
        ListNode next;

        private ListNode(int val){
            this.val = val;
        }

        private ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    } 

    ListNode front;
    ListNode rear;
    int size;
    int k;


    public MyCircularQueue(int k) {
        front = new ListNode(0);
        rear = front;
        this.size = 0;
        this.k = k;
    }
    
    public boolean enQueue(int value) {
        ListNode node = new ListNode(value);
        if(size < k){
            size++;
            rear.next = node;
            rear = node;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if(size == 0){
            return false;
        }
        front.next = front.next.next;
        if (front.next == null) {
            this.rear = this.front;
        }
        size--;
        return true;
    }
    
    public int Front() {
        return isEmpty() ? -1 : front.next.val;
    }
    
    public int Rear() {
        return isEmpty() ? -1 : rear.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == k;
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