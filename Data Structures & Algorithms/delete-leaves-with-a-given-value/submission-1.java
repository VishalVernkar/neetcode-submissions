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
    private TreeNode head;
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        head = root;
        removeNode(root, target, null, 0);
        return head;
    }

    private void removeNode(TreeNode node, int target, TreeNode parent, int side){
        if(node == null) return;

        // left = 0, right = 1
        removeNode(node.left, target, node, 0);
        removeNode(node.right, target, node, 1);
        
        // System.out.println(node.val + " " + node.left + " " + node.right);
        if(node.val == target && node.left == null && node.right == null){
            //System.out.println(node.val + " " + node.left + " " + node.right);
            if(parent == null){
                head = null;
                return;
            }
            // this logic fails as there are duplicates
            // I need a way to find the right point
            // I can use a flag to detrmine which side
            if(side == 0){
                parent.left = null;
            } else {
                parent.right = null;
            }
        }

    }
}

// 9:09 - 9:29

// Question
// remove given - leaf nodes
// leaf nodes are - nodes with no child
// as we remove if parent becomes leaf node we eove that to

// steps
// I can use post order traversal
// once we reach node check if it matches the target
// then
// if no leaf node remove it
// to remove it we need it's parent pointer