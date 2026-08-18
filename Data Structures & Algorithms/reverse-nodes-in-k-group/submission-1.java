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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;
        while(true){
            ListNode kth = getKth(groupPrev, k);
            if(kth == null) break;
            ListNode cur = groupPrev.next;
            ListNode nextList = kth.next;

            int i = k;
            while(i > 0){
                ListNode temp = cur.next;
                cur.next = nextList;
                nextList = cur;
                cur = temp;
                i--;
            }

            ListNode temp = groupPrev.next;
            groupPrev.next = nextList;
            groupPrev = temp;
        }
        return dummy.next;
    }

    private ListNode getKth(ListNode cur, int k){
        while(cur != null && k > 0){
            cur = cur.next;
            k--;
        }
        return cur;
    }

}

// 6:52

// reverse every k nodes in the group

// steps
// get first k nodes
// if not return the res

// reverse those k nodes - move to next group

// algo
// create a dummy node
// the k should end at end of group - this is to help with incompletegroup at the end
// get the next part of list kth.next
// start from next node of group prev
// reverse them
// now - th group prev should be at the end of the current node
// continue

