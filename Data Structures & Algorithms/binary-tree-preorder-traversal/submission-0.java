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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        fillPreOrderList(root, res);

        return res;
    }

    private void fillPreOrderList(TreeNode node, List<Integer> res){
        if(node == null) return;

        res.add(node.val);
        fillPreOrderList(node.left, res);
        fillPreOrderList(node.right, res);
    }
}

// 9:33
// root -> left -> right
// as I visit I add them to res

// using recursion
// if node == null return;
// add node.val
// recursion  call on node.left;
// recursion call on node.right;