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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode sum = res;
        int carry = 0;
        while(l1 != null && l2 != null){
            int curSum = l1.val + l2.val + carry;
            carry = curSum/10;
            int resVal = curSum%10;
            res.next = new ListNode(resVal);
            res = res.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            int curSum = l1.val + carry;
            carry = curSum/10;
            int resVal = curSum%10;
            res.next = new ListNode(resVal);
            res = res.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            int curSum = l2.val + carry;
            carry = curSum/10;
            int resVal = curSum%10;
            res.next = new ListNode(resVal);
            res = res.next;
            l2 = l2.next;
        }

        if(carry !=0) res.next = new ListNode(carry);

        return sum.next;

    }
}

// 7:20 - 7:30
// based on yesterday try
// add two numbers from each node
// take tenth place and carry forward it to next node
// take unit place and add it to res node
// at the end when the list ends if left with 2 digit reverse it and add it to res list
