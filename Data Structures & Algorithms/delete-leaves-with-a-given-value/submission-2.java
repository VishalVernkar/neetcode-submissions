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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return removeNode(root, target);
    }

    private TreeNode removeNode(TreeNode root, int target){
        if(root == null) return null;

        root.left = removeNode(root.left, target);
        root.right = removeNode(root.right, target);

        if(root.val == target && root.left == null && root.right == null){
            return null;
        }

        return root;
    }
}

// 18:24 - 18:40

// Question
// delete the leaf nodes node

// post order traversal
// if its left is null and right is null - return null