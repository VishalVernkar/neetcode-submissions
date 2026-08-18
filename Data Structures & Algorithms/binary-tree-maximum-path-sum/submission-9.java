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
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMaxPath(root);
        return maxPath;
    }

    private int getMaxPath(TreeNode root){
        if(root == null) return 0;

        int left = Math.max(0, getMaxPath(root.left));
        int right = Math.max(0, getMaxPath(root.right));

        maxPath = Math.max(maxPath, root.val + left + right);
        return root.val + Math.max(left, right);
    }
}

// the max path
// the path that passes throught the current root 
// the left path + root or right path from root

// we also get - negative path so we only keep positive ones