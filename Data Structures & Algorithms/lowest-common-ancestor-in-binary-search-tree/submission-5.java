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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while(cur != null){
            if(p.val < cur.val && q.val < cur.val){
                cur = cur.left;
            }else if(p.val > cur.val && q.val > cur.val){
                cur = cur.right;
            } else {
                return cur;
            }
        }
        return null;
    }
}

// 7:19 - 7:30

// Question
// given BST
// For a given two nodes get the common ancestor

// Steps
// thier ancestor are same until, the lie in a different sub tree
// as it is a BST - I can go where they lie - once they split that is wher they lie

// algo
// while cur!= null
// if(p and q on left side -> go left)
// if(p & q on right side -> go right)
// else 
// it is the common ancestor


// I can solve this
// I put expectations - to know the answer right away
// that's not how it supposed to be
// I need to understand the question - then solve
// I don't need to put idea - or perspective that I cannot solve
// I'm going to solve it - I'm doing it in right form - right way

//
// root=[5,3,8,1,4,7,9,null,2]
// p=1
// q=2

//          5
//      3        8
//   1    4    7   9
//      2

// 1 2 - go left
// 1 2 < 3 - go left
// 1 2 should return 1