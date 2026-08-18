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
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        res.add(root.val);
        while(!q.isEmpty()){
            for(int i = q.size(); i > 0; i--){
                TreeNode cur = q.poll();
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
            if(q.size() > 0)res.add((q.peekLast()).val);
        }
        return res;
    }
}


// 17:31 - 17:51

// Question
// nodes that are visible from right side
// which are those node?
// nodes that are to right of root right
// nodes that are not blocked by right side of root

// I can use BFS
// level order traversal
// at every end of queu insertion I take the last node that is inserted

// steps
// queue
// insert each level
// after insertion take the last inserted node val and add to res