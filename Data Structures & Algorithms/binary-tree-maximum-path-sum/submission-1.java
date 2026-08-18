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
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        return Math.max(sum(root), max);
    }

    private int sum(TreeNode root){
        if(root == null) return 0;

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);

        max = Math.max(max, Math.max(root.val,leftSum + rightSum + root.val));

        // System.out.println(root.val + " " + leftSum + root.val + " "+ rightSum + root.val +" " + max);

        return Math.max(leftSum + root.val, Math.max(rightSum + root.val, root.val));
    }


}

// 10:33 - 10:53

// give the max path sum

// Brute force
// 
// from each root -> left part and right part sum
// I have to take the max sum
// bottom up approach
// if I just take left part or right part I have to move up
// if I take both part I have to record it as max
// so recor max at each root => sum of left part + root + right part
// send the max of left part or right part

// steps
// post order traversal
// from bottom 
// for each root 
// I have 3 paths possible

// one from left that can go up
// one from right that can go up
// one that meets at root left -> root -> right

// every root I go
// 

// adding left is best or right is best 
