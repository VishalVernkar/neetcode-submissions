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
        while(true){
            if(cur.val == p.val){
                return p;
            } else if(cur.val == q.val){
                return q;
            }

            if(p.val < cur.val && q.val < cur.val){
                cur = cur.left;
            } else if(p.val > cur.val && q.val > cur.val){
                cur = cur.right;
            } else {
                return cur;
            }
        }
        //return null;
    }
}


// 11:20 - 11:40  - 12:10 

// I can solve - I want to give it a try
// I want to unserstand problem

// I have a BST - what is BST
// left - root - right -> Inorder traversal gives me sorted order traversal

// Question
// Lowest common ancestor of two given nodes
// what is LCA?
// I have to find the common paret of the given nodes

// how can I do it
// First I hae to search for these nodes
// I can use binary search
// next?
// i have to get their common ancestor, how?
// once I finde them I have to trace them back?



// // 
//         4
//       /   \
//      2     6
//     / \   / \
//    1   3 5   7
//       / \
//      8   9
// what if the two nodes are somewhere else?  
// like one on left of root and one on right of root
// like, if I take 1 7 or 3 5 -> thier LCA is 4

// I can look for these nodes by binary search?

// // 
//         4
//       /   \
//      2     6
//     / \   / \
//    1   3 5   7
//       / \
//      8   9

// 3 5 -> ans = 4
// bs 3
// root 4 -> 2 6
// 3? < 4 so go left
// curr = 2
// 3?  > 2 go right
// curr = 3
// 3? == 3 so found the node - as the values are unique looking for values is enough

// at the same time can I search for 
// 5?
// may be possible 


