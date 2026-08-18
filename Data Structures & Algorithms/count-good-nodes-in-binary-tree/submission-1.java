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
    private int count = 0;
    public int goodNodes(TreeNode root) {
        preorder(root, root.val);
        return count;
    }

    private void preorder(TreeNode node, int val){
        if(node == null) return;


        if(node.val >= val) count++;
        val = Math.max(node.val, val);

        preorder(node.left, val);
        preorder(node.right, val);
    }
}

// 18:02 - 18:20

// Question

// I feel I did not understand the question
// what I understood is count the node that are >= root node

// lets do pre order traversal 