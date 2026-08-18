class LRUCache {
    private class Node {
        int val;
        int key;
        Node next;
        Node prev;

        private Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        private Node(int val) {
            this.val = val;
        }
    }

    private class DoublyLinkedList {
        Node front;
        Node rear;
        int size;

        private DoublyLinkedList(int size) {
            this.front = new Node(-1, -1);
            this.rear = new Node(-1, -1);
            this.front.next = rear;
            this.rear.prev = front;
            this.size = size;
        }

        public void remove(Node node) {
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        public Node removeFront() {
            Node node = front.next;
            remove(node);
            return node;
        }

        public void insert(Node node) {
            // insert at rear
            Node prev = rear.prev;
            prev.next = node;
            rear.prev = node;
            node.prev = prev;
            node.next = rear;
        }
    }

    Map<Integer, Node> map;
    DoublyLinkedList list;
    int size;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        list = new DoublyLinkedList(capacity);
        size = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        list.remove(node);
        list.insert(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            list.remove(node);
            list.insert(node);
        } else {
            if (size == 0) {
                Node node = list.removeFront();
                map.remove(node.key);
                size++;
            }
            Node node = new Node(key, value);
            map.put(key, node);
            list.insert(node);
            size--;
        }
    }
}

// remove the least recent used
// doubley linked list
// insert at the front for most used - remove from the end if least used
