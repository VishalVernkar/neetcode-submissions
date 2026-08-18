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
        TreeNode cur = root;
        TreeNode insert = null;
        while(cur != null){
            if(val < cur.val){
                insert = cur;
                cur = cur.left;
            } else if(val > cur.val){
                insert = cur;
                cur = cur.right;
            }
        }

        if(val < insert.val){
            insert.left = new TreeNode(val);
        } else {
            insert.right = new TreeNode(val);;
        }
        return root;
    }
}