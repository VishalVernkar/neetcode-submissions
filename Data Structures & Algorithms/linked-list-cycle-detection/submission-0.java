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
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}

// 06:26

// we can use floyd's slow and fast pointer algorithm to determine a cycle
// slow moves one step and fast move 2 step at each iteration
// when they enter cycle they have to meet at one point.
// and when they meet they are equal and that is starting point of cycle
// if it is not a cycle the fast exits the loop.
