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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = n; i > 0; i--){
                TreeNode node = q.poll();
                if(i == n) res.add(node.val);
                if(node.right != null) q.offer(node.right);
                if(node.left != null) q.offer(node.left);
            }
        }
        return res;
    }
}


// I can use level order traversal 
// the node that comes first in the queu is the val;