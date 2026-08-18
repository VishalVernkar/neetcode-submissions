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
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        TreeNode cur = root;

        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                res.add(cur.val);
                if(cur.right != null) stack.push(cur.right);
                cur = cur.left;
            } else {
                cur = stack.pop();
            }
        }
        return res;
    }
}

// 9:40
// using stack - DFS 
// add val
// add 

// how does recursion moves
// for every node
// first add val
// call the recursion on node.left

// do I even need a stack??
// first add value
// add the right node to stack if not null
// move to left 
// if left is null + pop stack set it as curr


// inorder stack approach
// while cur and stack is not empty
// go all the way to the left
// then pop and add the value
// then go to right