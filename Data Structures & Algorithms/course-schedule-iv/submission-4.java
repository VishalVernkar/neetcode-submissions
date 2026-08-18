class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int n = numCourses;
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> graph = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            map.put(i, new HashSet<>());
        }

        int[] indegree = new int[n];
        for(int[] p : prerequisites){
            graph.get(p[0]).add(p[1]);
            indegree[p[1]]++;
        }

        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int course : graph.get(cur)){
                map.get(course).add(cur);
                map.get(course).addAll(map.get(cur));
                indegree[course]--;
                if(indegree[course] == 0) q.offer(course);
            }
        }

        List<Boolean> res = new ArrayList<>();
        for(int[] query : queries){
            res.add(map.get(query[1]).contains(query[0]));
        }

        return res;
    }
}

// 1. dfs on each querey

// 2. khan's topological
// we cam to the current course from this 
// we also cam from it's parent course