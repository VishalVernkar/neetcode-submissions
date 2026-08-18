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
        // int val = (root.left == null)? root.val : root.left.val;
        inorder(root);
        return res;
    }

    private void inorder(TreeNode node){
        if(node == null) return;

        inorder(node.left);
        // if(lastNode != null) System.out.println(lastNode.val);
        // if(lastNode != null && lastNode.val >= node.val) res = false;
        // lastNode = node;

        // System.out.println(val + " "+ node.val);
        // System.out.println(node.val);
        if(lastVal >= node.val) res = false;
        lastVal = node.val;

        inorder(node.right);
    }
}

// 19:57 - 20:17

// Question 
// Valid BST?
// Is valid when,
// left node < curr
// right
