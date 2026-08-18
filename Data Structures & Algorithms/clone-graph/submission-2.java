/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(!map.containsKey(cur)){
                map.put(cur, new Node(cur.val));
            }
            List<Node> copyList = map.get(cur).neighbors;
            for(Node n : cur.neighbors){
                if(!map.containsKey(n)){
                    map.put(n, new Node(n.val));
                    q.offer(n);
                }
                copyList.add(map.get(n));
            }
        }
        return map.get(node);
    }
}

// brute force
// go through each node - and it's list
// using hash map
// store the node and it's copy
// 