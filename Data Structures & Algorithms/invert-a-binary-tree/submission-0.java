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
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode node){
        if(node == null) return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        invert(node.left);
        invert(node.right);
    }
}

// 16:11
// left -> right
// right -> left
// 



//         4
//       /   \
//      2     6
//     / \   / \
//    1   3 5   7
//       / \
//      8   9

// Approach recursion
// if null return
// for every node
// swap left and right
// recursively call on root.left
// recursively call on root.right
// 

// it didn't work why?
// 