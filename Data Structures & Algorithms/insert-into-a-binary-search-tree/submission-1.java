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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        inOrder(root, val, root);
        return root;
    }

    // left - root - right
    private void inOrder(TreeNode node, int val, TreeNode insert){
        if(node == null){
            if(insert == null) return;
            if(val > insert.val){
                insert.right = new TreeNode(val);
            } else {
                insert.left = new TreeNode(val);
            }
            return;
        }

        if(val < node.val){
            inOrder(node.left, val, node);
        } else if(val > node.val){
            inOrder(node.right, val, node);
        }
    }
}

// 14:39 - 15:00

// I can use a inorder traversal
// how to determine the right place
// the given value can inserted when
// if val < node
//  go left -> forward possible insertion node
// if val > node 
//  go right -> forward possible insertion node

// should I use a recursion or stack?
// recursion once insertion is done - how to stop it


// Let's give it a try
// I don't need to think I can do it - I have no opinion - I want to focus on trying