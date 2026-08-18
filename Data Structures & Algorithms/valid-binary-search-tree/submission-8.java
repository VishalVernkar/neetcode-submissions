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
    private boolean res = true;    
    private int lastVal = Integer.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        inorder(root);
        return res;
    }

    private void inorder(TreeNode node){
        if(node == null) return;

        inorder(node.left);
        if(lastVal >= node.val) res = false;
        lastVal = node.val;
        inorder(node.right);
    }
}


class Solution2 {
    private boolean res = true;    
    // private int lastVal = Integer.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        inorder(root, null);
        return res;
    }

    private void inorder(TreeNode node, TreeNode lastNode){
        if(node == null) return;

        inorder(node.left, lastNode);
        if(lastNode != null && lastNode.val >= node.val) res = false;
        lastNode = node;
        inorder(node.right, lastNode);
    }
}


// 19:57 - 20:17

// Question 
// Valid BST?
// Is valid when,
// left node < curr
// right
