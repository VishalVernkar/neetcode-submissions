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
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode next = curr.next; // temp store the next part of list node
            curr.next = prev; // set prvious as next node
            prev = curr; // set curr as previous node
            curr = next; // iterate to next node
        }
        return prev;

    }
}

// reverse the linked list
// take first add prev
// update curr and prev
