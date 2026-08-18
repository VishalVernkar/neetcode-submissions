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
    int maxDia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDia;
    }

    private int maxDepth(TreeNode root){
        if(root == null) return -1;
        int left = 1 + maxDepth(root.left);
        int right = 1 + maxDepth(root.right);

        maxDia = Math.max(maxDia, left + right);

        return Math.max(left, right);
    }
}
