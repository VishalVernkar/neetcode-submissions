class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        
        dfs(graph, 0, -1, visited);
        for(int i = 0; i < n; i++){
            if(!visited.contains(i)) return false;
        }

        return true;

    }

    private boolean dfs(List<List<Integer>> graph, int node, int parent, Set<Integer> visited){
        if(visited.contains(node)) return false;
        visited.add(node);

        for(int cNode : graph.get(node)){
            if(cNode == parent) continue;
            if(!dfs(graph, cNode, node, visited)) return false;
        }
        return true;
    }
}


// 6:18
//

// a tree is valid if there are n - 1 edges
// if the nodes are connected 
// and every node should be able to reach every other node


// steps
// it is an undirected graph
// build the graph
// start from one node - and I should be able to visite them once
// 