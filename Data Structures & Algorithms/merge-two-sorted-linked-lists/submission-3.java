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
        ListNode mergedList = new ListNode();
        ListNode res = mergedList;

        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                mergedList.next = list1;
                list1 = list1.next;
            } else {
                mergedList.next = list2;
                list2 = list2.next;
            }
            mergedList = mergedList.next;
        }

        if(list1 != null){
            mergedList.next = list1;
        } else {
            mergedList.next = list2;
        }

        return res.next;
    }
}

// 06:15

// Mer two sorted linked lists
// merge them one bye one by comparing each node
// take the smaller one and move to next in the list
// once one of the list is done
// take the other list and attach the next part to res list

// we can use the same nodes
// we need a res head
// we move the lsit node is res list 
// and update the list to carry next part of list node