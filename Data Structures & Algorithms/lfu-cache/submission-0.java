class LFUCache {

    private class Node{
        int key, val, freq;
        Node prev, next;
        private Node(int key, int val){
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }

    private class DoublyLinkedList{
        Node head, tail;
        int size;
        private DoublyLinkedList(){
            size = 0;
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        // insert after head
        private void addNode(Node node){
            Node temp = head.next;
            head.next = node;
            node.prev = head;
            node.next = temp;
            temp.prev = node;
            size++;
        }

        private void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        private Node removeLast(){
            if(size > 0){
                 Node last = tail.prev;
                 tail.prev = last.prev;
                 last.prev.next = tail;
                 size--;
                 return last;
            }
            return null;
        }
    }

    Map<Integer, Node> keyMap;
    Map<Integer, DoublyLinkedList> freqMap;
    int minFreq;
    int capacity;
    int lfuSize;

    public LFUCache(int capacity) {
        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
        minFreq = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        // get from key map
        // update the freq
            // get the list from freq map
            // reomve node
            // update minFreq - if list is 0
            // update freq
            // update it in freq mapo
        if(!keyMap.containsKey(key)) return -1;
        Node node = keyMap.get(key);
        updateFreq(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        // check if key already exists
        // update its value - 
        // update ist freq 
        // else 
        // if teh capacity has reached - remove last from minFreq
        // add new node
        // update lfuSize
        if(keyMap.containsKey(key)){
            Node node = keyMap.get(key);
            node.val = value;
            updateFreq(node);
        } else {
            if(lfuSize == capacity){
                DoublyLinkedList list = freqMap.get(minFreq);
                Node last = list.removeLast();
                keyMap.remove(last.key);
                lfuSize--;
            }

            Node node = new Node(key, value);
            keyMap.put(key, node);
            minFreq = 1;
            DoublyLinkedList list = freqMap.getOrDefault(minFreq, new DoublyLinkedList());
            list.addNode(node);
            freqMap.put(minFreq, list);
            lfuSize++;
        }
     
    }

    private void updateFreq(Node node){
        int freq = node.freq;
        DoublyLinkedList list = freqMap.get(freq);
        list.remove(node);
        if(freq == minFreq && list.size == 0) minFreq++;

        node.freq = ++freq;
        list = freqMap.getOrDefault(freq, new DoublyLinkedList());
        list.addNode(node);
        freqMap.put(freq, list);
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
 
// 7:17

// Question

// I've to remove the LFU when the capacity increases
// if LFU is same remove the LCU

// steps 
// we can use a dpubly linked list to store the nodes in LCU order
// to track the frequency we can use the freqmap
// we can use a hash map to store keay value pair