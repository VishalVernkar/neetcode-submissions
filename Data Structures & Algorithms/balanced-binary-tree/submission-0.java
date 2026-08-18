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

    private boolean res = true;

    public boolean isBalanced(TreeNode root) {
        depth(root);
        return res;
    }

    private int depth(TreeNode node){
        if(node == null) return 0;

        int left = depth(node.left);
        int right = depth(node.right);

        int diff = Math.abs(left - right);
        System.out.println("node "+ node.val +" diff " + diff);
        if(diff != 0 && diff != 1) {
            if(res) res = false;
        }

        return 1 + Math.max(left, right);
    }
}

// 6:04 - 6:24
// When I'm solving problem I'm focused here


// DFS - REcusrion
// depth of left node
// depth of right node
// it's difference is not 0 or 1 return false
