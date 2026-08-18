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
    int idx = 0;
    TreeNode res = null;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res.val;
    }

    private void inorder(TreeNode node, int k){
        if(node == null || idx > k) return;

        inorder(node.left, k);
        if(++idx == k) res = node;
        inorder(node.right, k);
    }
}

// 08 - 028

// Question
// give the kth smallest value

// steps
// as it is a BST
// traverse in order
// once I reach kth position 
// I resturn that value;

// simplify
// 
