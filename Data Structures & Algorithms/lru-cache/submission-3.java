class LRUCache {

    class Node{
        int key;
        int val;
        Node prev;
        Node next;

        Node(int val){
            this.val = val;
        }

        Node(int key, int val){
            this.val = val;
            this.key = key;
        }
    }

    class DoublyLinkedList{
        Node front;
        Node rear;

        DoublyLinkedList(){
            front = new Node(0);
            rear = new Node(0);
            front.next = rear;
            rear.prev = front;
        }

        private void insert(Node node){
            // insert at rear
            Node prev = rear.prev;
            prev.next = node;
            node.prev = prev;
            node.next = rear;
            rear.prev = node;
        }

        private void remove(Node node){
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        private Node removeFirst(){
            Node node = front.next;
            remove(node);
            return node;
        }
    }

    Map<Integer, Node> map;
    DoublyLinkedList list; 
    int size;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        list = new DoublyLinkedList();
        size = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        list.remove(node);
        list.insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = null;
        if(map.containsKey(key)){
            node = map.get(key);
            node.val = value;
            list.remove(node);
            list.insert(node);
        } else {
            node = new Node(key, value);
            if(size == 0){
                Node front = list.removeFirst();
                map.remove(front.key);
                size++;
            }
            map.put(key, node);
            list.insert(node);
            size--;
        }
    }
}


// soubly list node
// hash map
