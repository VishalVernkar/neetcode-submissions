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
    boolean ans = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        preorder(root, subRoot);
        return ans;
    }

    private void preorder(TreeNode node, TreeNode subRoot){
        if(node == null) return;

        if(node.val == subRoot.val) {
            if(isSameTree(node, subRoot)) ans = true;
        }

        preorder(node.left, subRoot);
        preorder(node.right, subRoot);
    }

    private boolean isSameTree(TreeNode a, TreeNode b){
        if(a == null && b == null) return true;
        if(a == null || b == null || a.val != b.val) return false;

        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }
}

// 8:28 - 8:38
// find subroot in a tree

// Approach recursion - DFS
// traverse each node
// see if that node matches it
// I can use combination of 
// traversal plus + isSameTree method
// 

// how about once I find a val macthes I follow the 
