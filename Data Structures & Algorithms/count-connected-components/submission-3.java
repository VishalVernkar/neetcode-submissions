class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int res = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(graph, i, visited);
                res++;
            }
        }
        return res;
    }

    private void dfs(List<List<Integer>> graph, int node, boolean[] visited){
        if(visited[node]) return;

        visited[node] = true;
        for(int nei : graph.get(node)){
            if(!visited[nei]){
                dfs(graph, nei, visited);
            }
        }
    }
}

// 7:14

// Q
// connected components
// number of independent graphs


// Steps
// create a graph for undirected notes
// create a visit array
// from 0 to n
// dfs
// once a dfs runs - visits the nodes - it is one graph - count as 1
// continue
// start the dfs from unvisited node
