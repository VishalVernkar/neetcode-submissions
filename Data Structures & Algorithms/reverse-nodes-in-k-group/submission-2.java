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
    public ListNode reverseKGroup(ListNode head, int k) {
        // prevk - knodes - nextk
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode prevk = res;
        ListNode nextk = null;


        while(prevk.next != null){
            int n = k;
            ListNode cur = prevk.next;
            while(n > 0 && cur != null){
                cur = cur.next;
                n--;
            }
            nextk = cur;
            System.out.println(n);
            if(n > 0) return res.next;

            cur = prevk.next;
            ListNode prev = null;
            while(cur != nextk){
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp; // cur.next
            }

            // prev was at k -> is the head
            // prevk.next was at head -> is the tail
            ListNode tail = prevk.next;
            prevk.next = prev;
            tail.next = nextk;

            prevk = tail;
        }

        return res.next;
    }

}

// move to k nodes - reverse it
