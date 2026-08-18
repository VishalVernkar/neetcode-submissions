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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int left = 1 + maxDepth(root.left);
        int right = 1 + maxDepth(root.right);
        
        return Math.max(left, right);
    }
}

// Question
// Depth of a binary tree

// Approach
// level order traversal

// Dfs - How?
// for every node I visit I return 1
// 

//I'm trying to rmemeber code - no
// I want to understand code and go