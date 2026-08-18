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
    Map<TreeNode, Integer> map = new HashMap<>();
    public int rob(TreeNode root) {
        if(root == null) return 0;
        if(map.containsKey(root)) return map.get(root);
        
        int res = root.val;
        if(root.left != null){
            res += rob(root.left.left) + rob(root.left.right);
        }

        if(root.right != null){
            res += rob(root.right.left) + rob(root.right.right);
        }

        map.put(root, Math.max(res, rob(root.left) + rob(root.right)));

        return map.get(root);

    }


}

// we can rob the root + grandchildren
// we can rob the childrent

// brute force
// rob the root + rob left grand child + rob right grand child

// rob the left child + rob right child - return max of these tow


// as the values are repeatedly calculated - we can use DP and store the root -> its res

// 

