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
        ListNode curr = head;
        int count = 0;

        while(curr != null){
            count++;
            curr = curr.next;
        }
        // System.out.println(count);
        int idx = count - n;
        // System.out.println(idx);

        if(idx == 0) return head.next;

        int pos = 0;
        curr = head;
        // System.out.println(curr.val);
        // System.out.println(head.val);

        while(curr != null){
            pos++;
            if(pos == idx){
                curr.next = curr.next.next;
                return head;
            }
            curr = curr.next;
        }


        return null;

    }
}

// use count variable 
// once that index is reached
// 

// the node from last
// one way is traverse the list node once to get count 
// and remove the element in next iteration

// but can I do it in one iteration
