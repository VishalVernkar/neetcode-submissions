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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode parent = null;
        while(cur != null){
            if(key < cur.val){
                parent = cur;
                cur = cur.left;
            } else if(key > cur.val){
                parent = cur;
                cur = cur.right;
            } else {
                TreeNode insert = null;
                if(cur.left == null){
                    insert = cur.right;
                } else if(cur.right == null){
                    insert = cur.left;
                } else {
                    TreeNode node = cur.right;
                    while(node.left != null){
                        node = node.left;
                    }
                    node.left = cur.left;
                    insert = cur.right;
                }

                if(cur == root) return insert;

                if(parent.left == cur){
                    parent.left = insert;
                } else {
                    parent.right = insert;
                }
                return root;
            }
        }
        return  root;
    }
}

// find the node
// take left and right node of deleted node
// attach the right node to left most point in the left node
// if the root = delete
// return the left
// else attach the insert node to parent node