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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            k--;
            if(k == 0){
                return cur.val;
            }
            cur = cur.right;
        }
        return 0;
    }
}


// brute force 
// inorder traversal 
// get the list of elements
// when we reach k return;


// let's do it in time - understanding solution I should take - 10 - 20 -> not more than 20 mins
// if i'm taking more than 20 mins - note down the points I want to understand - do it later on the day or on the weekend
