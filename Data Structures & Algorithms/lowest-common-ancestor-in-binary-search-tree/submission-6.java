/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while(cur != null){
            if(p.val < cur.val && q.val < cur.val){
                cur = cur.left;
            } else if(p.val > cur.val && q.val > cur.val){
                cur = cur.right;
            } else {
                // when any one of them is equal
                // when one is on left and other is on right
                return cur;
            }
        }
        return root;
    }
}

// the point where both the nodes exist at left and right part is the lowest commn ancestror
