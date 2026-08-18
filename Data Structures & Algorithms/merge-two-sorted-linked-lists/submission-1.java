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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode();
        ListNode head = merged;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                merged.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                merged.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            merged = merged.next;
        }

        if(list1 != null){
            merged.next = list1;
        }

        if(list2 != null){
            merged.next = list2;
        }

        return head.next;
    }
}

// I can use a new list node
// traverse other two nodes and insert those to merged list node

// is merging in place possilbe?

// I'll try with new list node first
// start from each node 
// compare each node val
// while list1 != null and list2! = null
// if list1.val <= list.val
// add list1 to mergedNode -> update list1 to next 
// else list2 to mergedNode -> update list2 to next
// once any one becomes null 


// why while is not used?
