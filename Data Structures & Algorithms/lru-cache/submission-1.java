class LRUCache {

    private class Node{
        int key;
        int val;
        Node prev;
        Node next;

        private Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    Map<Integer, Node> map;
    Node left;
    Node right;
    int size;

    public LRUCache(int capacity) {
        this.size = capacity;
        map = new HashMap<>();
        left = new Node(0, 0);
        right = new Node(0, 0);
        left.next = right;
        right.prev = left;
    }

    private void insert(Node node){
        // insert right before the dummy right node
        Node prevRight = this.right.prev;
        prevRight.next = node;
        node.prev = prevRight;
        node.next = this.right;
        this.right.prev = node;
    }

    private void remove(Node node){
        // remove node from the current pos
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        insert(node);
        // System.out.println("get " + node.key + " " + node.val);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insert(newNode);

        if(map.size() > size){
            Node leftNode = this.left.next;
            remove(leftNode);
            map.remove(leftNode.key);
            // System.out.println("removed " + leftNode.key + " " + leftNode.val);
        }
    }
}

// Solve 18:33
// using doubly linked list so that I can rmove and insert it at right in O(1) time
// using hashmap - to store key with its node for O(1) acess

// Algo
// create a hashmap
// create a node class
// create a left and right dummy node - double linked
// dummy for easy insertion and removal
// create a method to perform remove and 
// method insert  
// in get,
// we get node from hash, if not return -1
// we remove node from its pos and insert it to the right
// in put,
// we create node -> add it to hashmap
// remove the exiting node for that key, if present
// insert it to the right
// if capacity exceeds
// get the left node remove it
// get its value remove from hashmap