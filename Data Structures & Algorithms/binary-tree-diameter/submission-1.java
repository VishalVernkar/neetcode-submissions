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
        if(root == null) return 0;

        int left = 1 + maxDepth(root.left);
        int right = 1 + maxDepth(root.right);

        maxDia = Math.max(maxDia, left + right - 2);

        return Math.max(left, right);
    }
}

// 5:53

// Question
// diameter = length of longest path between two nodes


// Approach
// diameter depends on depth of left tree and depth of right tree
// so sum it to get diameter
// we have to do it for every node

// Steps - how?
// dfs
// for every node I visit
// I'll try max depth dfs 
// but at the same time for every node I calculte sum of both
