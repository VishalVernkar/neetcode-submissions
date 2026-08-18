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
        Map<String, List<Pair>> graph = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            List<String> eqn = equations.get(i);
            graph.putIfAbsent(eqn.get(0), new ArrayList<>());
            graph.putIfAbsent(eqn.get(1), new ArrayList<>());
            graph.get(eqn.get(0)).add(new Pair(eqn.get(1), values[i]));
            graph.get(eqn.get(1)).add(new Pair(eqn.get(0), 1/values[i]));
        }


        double[] res = new double[queries.size()];
        int i = 0;
        for(List<String> q : queries){
            Set<String> visited = new HashSet<>();
            if(!graph.containsKey(q.get(0)) || !graph.containsKey(q.get(1))) {
                res[i++] = -1.0;
            } else {
                res[i++] = dfs(graph, visited, q.get(0), q.get(1)); 
            }
        }

        return res;

    }

    private double dfs(Map<String, List<Pair>> graph, Set<String> visited, String from, String to){
        if(from.equals(to)){
            return 1.0;
        }

        visited.add(from);
        for(Pair pair : graph.get(from)){
            if(visited.contains(pair.node)) continue;
            double val = dfs(graph, visited, pair.node, to);
            if(val != -1) return val * pair.val;
        }

        return -1.0;
    }

    
}

// build the directed graph - for both directions
// use visted set
// once the target is found return the result