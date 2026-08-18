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
        ListNode add = res;
        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            int remainder = sum%10;
            add.next = new ListNode(remainder);
            carry = sum/10;
            l1 = l1.next;
            l2 = l2.next;
            add = add.next;
        }

        while(l1 != null){
            int sum = l1.val + carry;
            int remainder = sum%10;
            add.next = new ListNode(remainder);
            carry = sum/10;
            l1 = l1.next;
            add = add.next;
        }

         while(l2 != null){
            int sum = l2.val + carry;
            int remainder = sum%10;
            add.next = new ListNode(remainder);
            carry = sum/10;
            l2 = l2.next;
            add = add.next;
        }

        if(carry > 0){
            add.next = new ListNode(carry);
        }
        return res.next;
    }
}


// brute force
// get the numbers
// reverse them
// add them
// create a linked list by reversing the result

// optimized
// Input: 

// 3 2 1
// 6 5 4
// 9 7 5
// l1 = [1,2,3], 
// l2 = [4,5,6]
// 5 7 9
// if > 9
// 10
// sum%10
// keep remainder here - carry the next number

// 5 9 9
// 5 9 9
// 1 9 8
