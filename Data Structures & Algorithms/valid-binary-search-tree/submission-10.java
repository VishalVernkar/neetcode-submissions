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
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        return isValid(root);
    }

    private boolean isValid(TreeNode root){
        if(root == null) return true;

        if(!isValid(root.left)) return false;

        if(prev != null && root.val <= prev.val) return false;
        prev = root;

        return isValid(root.right);
    }
}

// using inorder traversal
// the current node has to be grater than last visited node

// left < root < right
