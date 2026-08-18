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
        // BFS
        Queue<TreeNode> pQ = new LinkedList<>();
        pQ.offer(p);
        
        Queue<TreeNode> qQ = new LinkedList<>();
        qQ.offer(q);

        while(!pQ.isEmpty() && !qQ.isEmpty()){
            int pn = pQ.size();
            if(pn != qQ.size()) return false;
            for(int i = pn; i > 0; i--){
                TreeNode nodeP = pQ.poll();
                TreeNode nodeQ = qQ.poll();
                if(nodeP == null && nodeQ == null) continue;
                if(nodeP == null || nodeQ == null || nodeP.val != nodeQ.val) return false;
                pQ.offer(nodeP.left);
                pQ.offer(nodeP.right);
                qQ.offer(nodeQ.left);
                qQ.offer(nodeQ.right);
            }
        }
        return true;
    }
}
