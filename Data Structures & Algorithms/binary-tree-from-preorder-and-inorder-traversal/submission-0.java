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
    int inIdx = 0;
    int preIdx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int limit){
        if(preorder.length == preIdx) return null;
        if(inorder[inIdx] == limit){
            inIdx++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIdx++]);

        root.left = dfs(preorder, inorder, root.val);
        root.right = dfs(preorder, inorder, limit);

        return root;
    }
}

// 9:47 - 10:00

// Tree from - inorder and preorder array
// we take root from - preorder - as -> root - left - right
// we take left and right part from preorder based on inorder
// we first get the root
// we only go left for current node till we reach root.val - once we reach we icrement the inorder index
// we only go right for current node till we reach parent of root node - once we reach we icrement the inorder index
// base case: for the main root node we don't have the parent to set its limit - so we use max value as limit - then as we reach preorder end we stop
// 

