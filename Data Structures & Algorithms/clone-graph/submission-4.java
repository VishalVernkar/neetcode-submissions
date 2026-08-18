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
        if(node == null ) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        map.put(node, new Node(node.val));
        q.offer(node);

        while(!q.isEmpty()){
            Node cur = q.poll();
            List<Node> list = map.get(cur).neighbors;
            for(Node neigh : cur.neighbors){
                if(!map.containsKey(neigh)){
                    map.put(neigh, new Node(neigh.val));
                    q.offer(neigh);
                }
                list.add(map.get(neigh));
            }
        }
        return map.get(node);
    }
}

// to clone the graph we use BFS
// first offer node to queue
// for each node in que
// poll it

// for each list - if  the node we encounter is a new - we create copy - add the cur to queue