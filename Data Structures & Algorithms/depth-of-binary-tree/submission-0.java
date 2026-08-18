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
    private int res = 0;
    public int maxDepth(TreeNode root) {
        getDepth(root, 0);
        return res;
    }

    private void getDepth(TreeNode node, int len){
        if(node == null){
            res = Math.max(res, len);
            return;
        }
        len++;
        getDepth(node.left, len);
        getDepth(node.right, len);
    }
}

// 17:03
// Find the max depth of tree

// go all the way down to each node

// how can I do that?
// check at each level?

// DFS
// recursion go all the way to left
// go all the way to right
// if null is reached reeset the point   
