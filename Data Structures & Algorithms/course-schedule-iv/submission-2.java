class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        for(int[] p : prerequisites){
            graph.get(p[1]).add(p[0]);
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < numCourses; i++) dfs(graph, i, map);

        List<Boolean> res = new ArrayList<>();
        for(int[] query : queries){
            res.add(map.get(query[1]).contains(query[0]));
        }
        return res;
    }

    private Set<Integer> dfs(List<List<Integer>> graph, int course, Map<Integer, Set<Integer>> map){
        if(map.containsKey(course)) return map.get(course);
        Set<Integer> prerequisites = new HashSet<>();
        for(int preCrs : graph.get(course)){
            prerequisites.addAll(dfs(graph, preCrs, map));
        }
        prerequisites.add(course);
        map.put(course, prerequisites);
        return prerequisites;
    }
}

// 6:34
// check for given query if v is a prerequisite of u

// steps
// we can dfs once the and create a set for every node - that has its prerequisites including indirect ones

// for each query, then check if the node is prerequiste in the set

// 1 -> 0