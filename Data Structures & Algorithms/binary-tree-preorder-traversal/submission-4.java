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
        // List<Integer> res = new ArrayList<>();
        // preorder(root, res);
        // return res;

        return preorderStack(root);
    }

    private void preorder(TreeNode root, List<Integer> res){
        if(root == null) return;

        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    private List<Integer> preorderStack(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode cur = root;

        while( cur!= null || !stack.isEmpty()){
            if(cur == null){
                cur = stack.pop();
                cur = cur.right;
                continue;
            }
            stack.push(cur);
            res.add(cur.val);
            cur = cur.left;
        }

        return res;

    }
}

// 16:52

// using stack
// add root
// go all the way to left
// then pop stack go right