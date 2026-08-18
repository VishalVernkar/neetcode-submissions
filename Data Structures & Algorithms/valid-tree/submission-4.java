class Solution {
    Set<Integer> visited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        if(!dfs(graph, 0, Integer.MAX_VALUE)) return false;
        if(visited.size() != n) return false;
        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int num, int parent){
        if(visited.contains(num)) return false;

        visited.add(num);
        List<Integer> list = graph.get(num);
        for(int child : list){
            if(child == parent) continue;
            if(!dfs(graph, child, num)) return false;
        }
        return true;
    }
}


// each node is visited only once - at the current level
// 