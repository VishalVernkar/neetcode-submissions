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
        TreeNode parent = root;
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
                    TreeNode temp = cur.right;
                    // TreeNode parentTemp = null;
                    while(temp.left!=null){
                        // parentTemp = temp;
                        temp = temp.left;
                    }
                    temp.left = cur.left;
                    insert = cur.right;
                }

                if(cur == root){
                    return insert;
                }

                if(parent.left != null && parent.left.val == key){
                    parent.left = insert;
                } else {
                    parent.right = insert;
                }
                return root;
            }
        }

        return root;
        
    }
}

// 15:30 - 15:50
// BST

// Question
// Search the node
// remove it

// solve
// I can search it
// how to reconstrut the child nodes


// steps
// search
// remove
// build the node to be inserted
// get left child and get right child
// if right child is null -> insert left child at deleted pos
// if left child is null -> insert right child at deleted pos
// else
// take right -> go to left most end -> insert left child to the left
// now insert this reconstructed node to deleted pos

// insert at the removed position


