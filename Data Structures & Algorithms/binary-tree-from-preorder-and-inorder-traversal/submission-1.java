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
        return construct(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode construct(int[] preorder, int[] inorder, int limit){
        if(preIdx >= preorder.length) return null;

        if(inorder[inIdx] == limit){
            inIdx++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[preIdx++]);
        root.left = construct(preorder, inorder, root.val);
        root.right = construct(preorder, inorder, limit);
        return root;
    }
}

// preorder gives root
// using root inorder gives point where we can split left part and right part

// brute force would be
// finding the root in inorder - every time
// get the left part and right part

// at the same we can split the preorder array as left part and right part
// get the lfet part and right

// recursively do this for the array 

// we can simplify this by using the hashmap - as elements are unique - we store element -> index - for O(1) access


// we can eliminate the hash map by using
// dfs
// where we limit the left tree construction by using inorder
