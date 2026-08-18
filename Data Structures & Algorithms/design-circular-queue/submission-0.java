class MyCircularQueue {

    Node circulerQueue;
    Node front;
    Node rear; 
    int size;
    int idx = 0;

    public MyCircularQueue(int k) {
        circulerQueue = new Node(-1);
        Node curr = circulerQueue;
        size = k;
        int n = k;
        while(--n > 0){
            curr.next = new Node(-1);
            curr = curr.next;
        }
        curr.next = circulerQueue;
        front = circulerQueue;
        rear = front;
    }

    public boolean enQueue(int value) {
        if(idx == size) return false;
        idx++;
        if(idx == 1) {
            rear.value = value;
        } else if(idx > 1) {
            rear = rear.next;
            rear.value = value;
        }
        return true;
    }
    
    public boolean deQueue() {
        if(idx == 0) return false;
        idx--;
        front.value = -1;
        front = front.next;
        return true;
    }
    
    public int Front() {
        return front.value;
    }
    
    public int Rear() {
        return rear.value;
    }
    
    public boolean isEmpty() {
        if(idx==0) return true;
        return false;
    }
    
    public boolean isFull() {
        if(idx  == size) return true;
        return false;
    }

    private class Node{
        int value;
        Node next;

        private Node(int value){
            this.value = value;
            this.next = null;
        }
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

 // 13:20 - 13:40
 // 14:48 - 15:00 

 // create a circular queue

 // Approach
 // Hint: linked list
 // create a list node of size k
 // point start node and end node to beginning
 // add elements to end
 // remove node value from start - move it to next pointer node

// so it is mainly based on pointer
