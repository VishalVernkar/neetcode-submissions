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
        if(left == right) return head;
        ListNode cur = head;
        ListNode prevLeft = null;

        int idx = 0; 
        while(cur != null){
            idx++;
            if(idx == left){
                // reverse till I find right
                ListNode next = reverse(cur, left, right);
                if(prevLeft != null){
                    prevLeft.next = next;
                } else {
                    head = next;
                }
            }
            prevLeft = cur;
            cur = cur.next;
        }

        return head;
    }

    public ListNode reverse(ListNode start, int left, int right){
         // reverse till I find right
        ListNode prev = null;
        ListNode cur = start;
        while(right != left){
            left++;
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        ListNode next = cur.next;
        cur.next = prev;
        start.next = next; // rest of the list
        return cur;
    }

}

// 10:47 - 11:13
// reverse the linked list from the given left position to right position

// traverse the list node
// reach the start pos
// start reversing from there till i reach end position
// then attach rest of the elements

// 1 -> 2 -> 3 -> 4 -> 5
// pos 2 - 4
// 2 -> null
// 3 -> 2
// 4 -> 3 -> 2
// 1 -> 4 -> ... => attach to orginal
// 2 -> 5 -> ... => attach end to here