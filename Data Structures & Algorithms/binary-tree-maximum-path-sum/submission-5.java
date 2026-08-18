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
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root); 
        return maxPath;
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;

        int left = Math.max(0, dfs(root.left));
        int right =  Math.max(0,dfs(root.right));

        maxPath = Math.max(maxPath, root.val + left + right);

        return root.val + Math.max(left, right); 
    }
}

// 12:53


// Question
// find the path - whose sum of nodes is max
// path can start and at any node - optional to include root or leaf nodes - it has to be single path

// steps
// at a given node 
// best is 
// the path that is pasing root node - laft path sum + root + right path sum - we track this
// for the parent - we return best among - node.val + math.max(left path, right path)
// to handle 0 - we take max( 0, dfs()) - returned values
