class Solution {
    Set<Integer> visited = new HashSet<>();
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n ; i++) graph.add(new ArrayList<>());

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            if(!visited.contains(i)){
                dfs(graph, i, -1);
                res++;
            }
        }

        return res;
    }

    private void dfs(List<List<Integer>> graph, int num, int parent){
        if(visited.contains(num)) return;
        visited.add(num);
        List<Integer> list = graph.get(num);
        for(int nei : list){
            if(nei == parent) continue;
            dfs(graph, nei, num);
        }
    }
}

// 