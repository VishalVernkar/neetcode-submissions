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
        ListNode temp = new ListNode();
        ListNode res = temp;

        int n = lists.length;
        for(int i = 0; i < n; i++){
            while(lists[i] != null){
                ListNode insert = lists[i];
                int idx = i;
                for(int j = i + 1; j < n; j++){
                    if(lists[j] == null) continue;

                    if(insert.val > lists[j].val){
                        insert = lists[j];
                        idx = j;
                    }
                }
                temp.next = insert;
                temp = temp.next;
                lists[idx] = insert.next;
            }
        }
        return res.next;
    }
}

// 06:52
// Brute force
// go through each node list
// compare each element from each node
// at the end add the smallest one
// update its pointer
// 

// this should be n * k

// Algo
// take first node from each node list