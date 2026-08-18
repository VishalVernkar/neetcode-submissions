/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node cur = head;
        while(cur != null){
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }

        // update random nodes
        cur = head;
        while(cur != null){
            Node copy = cur.next;
            if(cur.random != null) copy.random = cur.random.next;
            cur = copy.next;
        }

        // unwind the list
        Node res = new Node(0);
        Node copy = res;
        cur = head;
        while(cur != null){
            copy.next = cur.next;
            cur.next = cur.next.next;
            copy = copy.next;
            cur = cur.next;
        }

        return res.next;
    }
}
// using hash map

// storing copy next to original -> A -> A' -> B -> B'
