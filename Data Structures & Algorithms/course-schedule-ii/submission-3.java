class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        int n = numCourses;
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());

        int[] indegree = new int[n];

        for(int[] p : prerequisites){
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        int[] res = new int[n];
        int i = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            res[i++] = cur;
            for(int course : graph.get(cur)){
                indegree[course]--;
                if(indegree[course] == 0) q.offer(course); 
            }
        }

        return (i == numCourses)? res : new int[0];
    }
}

// 
