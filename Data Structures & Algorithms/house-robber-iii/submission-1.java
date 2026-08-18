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
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return  Math.max(res[0], res[1]);
    }

    private int[] dfs(TreeNode root){
        if(root == null) return new int[]{0, 0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
 
        int rob = root.val + left[1] + right[1];
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0],  right[1]);

        return new int[]{rob, notRob};
    }
}

// 12:38

// Question
// once he robs root he cannot rob children


// Steps
// at a given point 
// rob the root -> cannot rob children
// not rob the root -> rob from the children -> but it is also possible I can choose best from the children -> that could be grand children -> or their children

// DFS
// if I come from bottom
// for the bottom root with n children
// two things are there
// rob root - root.val
// not rob root - rob from children - 0

// now at parent of this root
// rob - root.val(parent) + notrob part of children
// not rob root - sum of best of (rob, not rob) of both children - as there is possiblity I ca pic any node from children