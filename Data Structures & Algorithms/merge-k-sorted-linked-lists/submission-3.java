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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return divide(lists, 0, lists.length - 1);
    }

    private ListNode divide(ListNode[] lists, int l, int r){
        if(l == r) return lists[l];

        int m = l + (r - l) / 2;
        ListNode l1 = divide(lists, l, m);
        ListNode l2 = divide(lists, m + 1, r);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2){
        ListNode res = new ListNode(0);
        ListNode list = res;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                list.next = l1;
                l1 = l1.next;
            } else {
                list.next = l2;
                l2 = l2.next;
            }
            list = list.next;
        }

        if(l1 != null){
            list.next = l1;
        } else {
            list.next = l2;
        }

        return res.next;
    }


}


// using divide and conquer
