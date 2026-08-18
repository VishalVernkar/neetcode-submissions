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
    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // mid point -> slow
        ListNode secondHalf = slow.next;
        slow.next = null; // set the fast half to loose sencond half

        // reverse the second half;
        ListNode prev = null;
        while(secondHalf != null){
            ListNode next = secondHalf.next;
            secondHalf.next = prev;
            prev = secondHalf;
            secondHalf = next;
        }

        secondHalf = prev;
        ListNode firstHalf = head;

        while(secondHalf != null){ // take shorter one since we don't want to end up null pointer exception
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = temp1;

            firstHalf = temp1;
            secondHalf = temp2;

        }
        //return head;
    }
}

// 06:48
// we can see that first half elements are taking positions till mid reacches end
// and rest of the elements are revesed and placed alternately b/w those first half

// we can find the mid point
// reverse the second half
// merge them alternatively

// we can find the mid point uisng floyds slow and fast
// slow moves once and fast twice
// by the end slow will be at the middle