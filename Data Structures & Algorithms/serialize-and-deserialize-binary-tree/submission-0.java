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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "<$#>";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        res.append("<");
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = n; i > 0; i--){
                TreeNode cur = q.poll();

                if(cur == null){
                    res.append("$#");
                } else {
                    res.append("$");
                    res.append(cur.val);
                }

                if(cur != null) q.offer(cur.left);
                if(cur != null) q.offer(cur.right);
            }
        }
        res.append(">");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode cur = null;
        int num = 0;
        int n = data.length();
        for(int i = 0; i < n; i++){
            char c = data.charAt(i);
            if(c == '<'){
                cur = new TreeNode();
                i++;
            } else if(c == 36){
                if(cur != null){
                    cur.val = num;
                    q.offer(cur);
                }
                cur = new TreeNode();
                num = 0;
            } else if(c >= '0' && c <= '9'){
                num = num * 10 + (c - '0'); 
            } else if(c == '#'){
                cur = null;
                q.offer(cur);
            } else {
                if(cur != null){
                    cur.val = num;
                    q.offer(cur);
                }
            }
        }

        Queue<TreeNode> q2 = new LinkedList<>();
        TreeNode root = q.poll();
        if(root == null) return root;
        q2.offer(root);
        while(!q2.isEmpty()){
            int size = q2.size();
            for(int i = 0; i < size; i++){
                cur = q2.poll();
                cur.left = q.poll();
                if(cur.left != null) q2.offer(cur.left);
                cur.right = q.poll();
                if(cur.right != null) q2.offer(cur.right);
            }
        }

        return root;
        
        
    }
}

// 19:05 - 19:20

// if it is < - start - new root node
// if it is dollar - it is - get the previous num - create node add it - then start the new num

// 14:58 - 15:20
// Question
// serialize the tree as string and deserialize it 

// steps
// serialize - format -> $val$val$#$#...
// $ for start of val -> # for null

// build string in level order traversal
// recreate it into tree node using level order traversal

// deserialize
// what is good?
// using queue
// read complete string and load it in queue
