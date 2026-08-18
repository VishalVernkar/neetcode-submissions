/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode node = head;
        ListNode prevNode = new ListNode(node.val);
        while(node.next != null){
            ListNode currNode = new ListNode(node.next.val);
            currNode.next = prevNode;
            prevNode = currNode;
            node = node.next;
        }
        return prevNode;
    }
}


// create a new list node where you add elements from last
// new node -> add current to its next

// 0 1 2
// new node(0)
// new node(1)
// new node(2)

// new node(0)
// new node(1) -> new node(0)
// new node(2) -> new node(1) -> new node(0);