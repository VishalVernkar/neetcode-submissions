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
    boolean isSame = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        compare(p, q);
        return isSame;
    }

    private void compare(TreeNode p, TreeNode q){
        if(p == null && q == null) return;

        if( (p == null || q == null)) {
            isSame = false;
            return;
        }

        if(p.val != q.val) {
            isSame = false;
            return;
        }

        compare(p.left, q.left);
        compare(p.right, q.right);
    }
}

// 6:25

// Question
// compare two trees - return if they are same

// Steps
// Recursion
// compare both trees
