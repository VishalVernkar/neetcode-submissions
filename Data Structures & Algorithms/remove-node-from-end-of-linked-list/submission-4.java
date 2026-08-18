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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode fast = head;
        ListNode slow = dummy;

        while(n > 0){
            fast = fast.next;
            n--;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}

// 07:05 - 7:17
// remove nth element from end position

// direct way is to get the count of elements and then get the index of the element from beginnnning by count - n

// we can do it in one pass using floyd's algorithm
// we set the fast pointer at nth postion from beginning
// the we move slow pointer from begiining and 
// fast from nth pos from bginning
// as the fast reaches end the slow will end up nth pos from end

// we need a dummy node 
// for case when there is only one node in list node
// or 
// in case we have to remove first node - where nth pos from end - points at nth node
