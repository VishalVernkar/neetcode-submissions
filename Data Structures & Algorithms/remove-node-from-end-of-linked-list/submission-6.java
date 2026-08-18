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
        ListNode  fast = head;
        int count = n;
        while(n-- > 0) fast = fast.next;
        if(fast == null) return head.next;
        ListNode  slow = head;
        while(fast.next!= null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}


// using slow and fast
// put fast at n distance
// move slow and fast -> once fast reches ebnd slow is at n distance
//     S   F
// 0 1 2 3
// 1 2 3 4
// fast
// n       2 1
// F=1     2 3 

// S=1  2
// F=3  4 

// S   F
// 0 1 2 3
// 1 2 3 4

// Actually  I want to end up at one efore so -> fast.next != null

