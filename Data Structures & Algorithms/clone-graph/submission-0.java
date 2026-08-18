class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node cur, Map<Node, Node> map){
        if(cur == null) return null;
        if(map.containsKey(cur)) return map.get(cur);

        Node copy = new Node(cur.val);
        map.put(cur, copy);

        for(Node node : cur.neighbors){
            copy.neighbors.add(dfs(node, map));
        }

        return copy;
    }
}

//  6:44

// Question

// deep copy of graph
// each graph node has
// list of nodes - it is linked to


// we can use a hashmap - to track the original to copy node
// at a given point best way to crete copy
// create a copy of the node
// traverse it's list
// create its copy
// - as the list nodes are linked to other nodes through thier list
// we can use dfs - so when we add from original to copy we dfs that node

// we use hashmap
// it the node alresy exists - we taki it from amp
// else create a new node.

// we start with a node
// if it already exists we return it
// else we create a new node