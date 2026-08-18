class Solution {
    private class Pair{
        String node;
        double val;

        private Pair(String node, double val){
            this.node = node;
            this.val = val;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // build the graph
        Map<String, List<Pair>> graph = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            List<String> eqn = equations.get(i);
            graph.computeIfAbsent(eqn.get(0), k -> new ArrayList<>()).add(new Pair(eqn.get(1), values[i]));
            graph.computeIfAbsent(eqn.get(1), k -> new ArrayList<>()).add(new Pair(eqn.get(0), 1/values[i]));
        }

        double[] res = new double[queries.size()];
        int i = 0;
        for(List<String> q : queries){
            Set<String> visited = new HashSet<>();
            if(!graph.containsKey(q.get(0)) || !graph.containsKey(q.get(1))){
                res[i++] = -1.0;
            } else {
                res[i++] = dfs(graph, q.get(0), q.get(1), visited);
            }

        }
        return res;

    }

    // dfs fucntion 
    private double dfs(Map<String, List<Pair>> graph, String src, String target, Set<String> visited){
        if(src.equals(target)){
            return 1.0;
        }

        visited.add(src);
        for(Pair nextSrc : graph.get(src)){
            if(visited.contains(nextSrc.node)) continue;
            double val = dfs(graph, nextSrc.node, target, visited);
            if(val != -1.0){
                return val * nextSrc.val;
            }
        }

        return -1.0;
    }
}

// using dfs