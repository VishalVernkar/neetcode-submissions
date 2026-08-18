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
        ListNode cur = res; 
        cur.next = head;

        right = right - left + 1;
        while(left-- > 1) cur = cur.next;
        ListNode beforeLeftNode = cur;

        // while(right-- > 0) cur = cur.next;
        // ListNode afterRightNode =  cur;

        // reverse
        cur = beforeLeftNode.next;
        ListNode leftNode = cur;
        ListNode prev = null;

        while(right-- > 0){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        } 

        beforeLeftNode.next = prev;
        leftNode.next = cur;


        return res.next;

    }
}

// reverse a b left --- right c d
// possible 
// l  - r - continue
// conintue - l - r - continue
// continue - l - r

// if(left is at start)

// if(right is at the end)


// find left and right point

// find left point - revere form there  