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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return compare(p, q);
    }

    private boolean compare(TreeNode a, TreeNode b){
        if(a == null && b == null) return true;
        if(b == null) return false;
        if(a == null) return false;

        if(a.val != b.val) return false;

        return compare(a.left, b.left) && compare(a.right, b.right);
    }
}

// 7:07 : 7:27

// check if two tree values are same - if they have same sturcture and same val

// approach
// traverse both nodes
// they either have to be null or must have same val

// I can use pre order traversal
// check if two nodes are equal
// 