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
        TreeNode curr = root;

        while(curr != null){
            res.add(curr.val);

            if(curr.left != null && curr.right != null){
                TreeNode pred = curr.left;
                while(pred.right != null && pred.right != curr.right) pred = pred.right;
                
                if(pred.right == null){
                    pred.right = curr.right;
                    curr = curr.left;
                } else {
                    curr = pred.right;
                    pred.right = null;
                }
            } else if(curr.left == null){
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        return res;
    }
}

// Using Morris traversal
// In inorder traversal
// temprarily add the root node to -> right most node of left side 
// why?
// becasue once I reach the right node I should have that root node next 

// if curr.left == null
// add to res
// cur = curr.right
// else
// pred = curr.left
// go to right most node
// add root node to the right of right most node
// then go to curr = curr.left
// else
// it has pred = cur
// so we add it -> we processed root most
// and we remove it from right moset node
// curr = curr.right

// How can I implement this in -> preorder traversal
// root - left - right
// as I move in tree 
// I have direct access to root and to left
// if left is null I want to go to right
// so I need to process - right - I need it temporarily on right of left?
// yes - go to right most from left of root - add root.right 