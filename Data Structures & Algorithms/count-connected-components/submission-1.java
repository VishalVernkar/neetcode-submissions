class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] edge:edges){
            List<Integer> list = graph.getOrDefault(edge[0], new ArrayList<>());
            list.add(edge[1]);
            graph.put(edge[0], list);
            list = graph.getOrDefault(edge[1], new ArrayList<>());
            list.add(edge[0]);
            graph.put(edge[1], list);
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            if(!graph.containsKey(i)) count++;
        }

        for(int i = 0; i < n; i++){
            if(graph.containsKey(i)){
                Set<Integer> visited = new HashSet<>();
                dfs(graph, visited, i, -1);
                for(int node : visited) graph.remove(node);
                count++;
            }
        }
        return count;
    }

    private void dfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int node, int parent){
        if(visited.contains(node)) return;
        visited.add(node);

        for(int nd : graph.get(node)){
            if(parent == node) continue;
            dfs(graph, visited, nd, node);
        }
    }
}

// 14:31

// Question
// return the disconnected number of graphs




// How can I determine it the graph is connected - 

// direct way 
// get all the visited nodes and romve from graph
// do this until it's empty

// what if I start from some other node
// it is an undirected graph startng fromm any node is fine
// 

// use hash map for the graph

// is there other way 
// 

// I've to solve in time - I've to get the intuition in first 10 mins 
// then start solving