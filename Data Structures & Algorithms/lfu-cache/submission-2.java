class LFUCache {
    class Node{
        int key;
        int val;
        int freq = 1;
        Node next;
        Node prev;

        Node(int val){
            this.val = val;
        }

        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    class DoublyLinkedList{
        Node front;
        Node rear;
        int size;

        DoublyLinkedList(){
            front = new Node(0);
            rear = new Node(0);
            front.next = rear;
            rear.prev = front;
            size = 0;
        }

        private void insert(Node node){
            Node prev = rear.prev;
            prev.next = node;
            node.prev = prev;
            node.next = rear;
            rear.prev = node;
            size++;
        }


        private void remove(Node node){
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            size--;
        }

        private Node removeFirst(){
            Node first = this.front.next;
            remove(first);
            return first;  
        }

    }

    Map<Integer, Node> map;
    Map<Integer, DoublyLinkedList> freqMap;
    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        map = new HashMap<>();
        freqMap = new HashMap<>();
        this.capacity = capacity;
        minFreq = 0;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        update(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            update(node);
        } else {
            if(capacity == 0){
                DoublyLinkedList list = freqMap.get(minFreq);
                Node lfu = list.removeFirst();
                map.remove(lfu.key);
                capacity++;
            }

            Node node = new Node(key, value);
            map.put(key, node);
            minFreq = 1;
            DoublyLinkedList list = freqMap.getOrDefault(1, new DoublyLinkedList());
            list.insert(node);
            freqMap.putIfAbsent(1, list);
            capacity--;
        }
    }

    private void update(Node node){
        // get the freq of node
        // get its list
        // remove from the list
        // update the freq
        // insert in the new list
        // update minFreq
        int freq = node.freq;
        DoublyLinkedList list = freqMap.get(freq);
        list.remove(node);
        if(freq == minFreq && list.size == 0) minFreq++;
        
        freq = ++node.freq;
        list = freqMap.getOrDefault(freq, new DoublyLinkedList());
        list.insert(node);
        freqMap.putIfAbsent(freq, list);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

 // map > key - node
 // mao -> freq - doubly list