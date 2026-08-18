class LFUCache {

    class Node{
        int key, val;
        Node prev, next;
        int freq;

        Node(int val){
            this.val = val;
            freq = 1;
        }

        Node(int key, int val){
            this.key = key;
            this.val = val;
            freq = 1;
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
            Node node = front.next;
            remove(node);
            return node;
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
            Node node = new Node(key, value);
            if(capacity == 0){
                DoublyLinkedList list = freqMap.get(minFreq);
                Node first = list.removeFirst();
                map.remove(first.key);
                capacity++;
            }
            map.put(key, node);
            minFreq = 1;
            DoublyLinkedList list = freqMap.getOrDefault(minFreq, new DoublyLinkedList());
            list.insert(node);
            freqMap.putIfAbsent(minFreq, list);
            capacity--;
        }
    }

    private void update(Node node){
        // remove from existing list and add it to the new freq
        DoublyLinkedList list = freqMap.get(node.freq);
        list.remove(node);
        if(node.freq == minFreq && list.size == 0) minFreq++;

        node.freq++;
        list = freqMap.getOrDefault(node.freq, new DoublyLinkedList());
        list.insert(node);
        freqMap.putIfAbsent(node.freq, list);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

