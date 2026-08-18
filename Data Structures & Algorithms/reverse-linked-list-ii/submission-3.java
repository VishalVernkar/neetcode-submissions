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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode cur = res;

        int n = left;
        while(n > 1){
            cur = cur.next;
            n--;
        }

        ListNode beforeLeft = cur;
        n = right - left + 1;
        
        cur = beforeLeft.next;
        ListNode prev = null;
        while(n > 0){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            n--;
        }

        ListNode tail = beforeLeft.next;
        beforeLeft.next = prev;
        tail.next = cur;
        return res.next;
    }
}