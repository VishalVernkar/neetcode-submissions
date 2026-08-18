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
    boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return balanced;
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;

        int left = 1 + dfs(root.left);
        int right = 1 + dfs(root.right);

        if(balanced && Math.abs(left - right) > 1) balanced = false;

        return Math.max(left, right);
    }
}

// 6:09

// Question
// so the depth of diff bewtween left and right should not be more than 1