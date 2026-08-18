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
        TreeNode cur = root;
        while(cur != null){
            res.add(cur.val);
            if(cur.left == null){
                cur = cur.right;
            } else {
                TreeNode prev = cur.left;
                while(prev.right != null && prev.right != cur){
                    prev = prev.right;
                }

                if(prev.right == null){
                    prev.right = cur.right;
                    cur = cur.left;
                } else {
                    cur = prev.right;
                    prev.right = null;
                }
            }
        }

        return res;
    }

    private void preorder(TreeNode root, List<Integer> list){
        if(root == null) return;

        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }
}

// using recursion
// 