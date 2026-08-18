class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for(int[] pre : prerequisites){ 
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) q.offer(i);
        }

        int finish = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            finish++;
            List<Integer> list = graph.get(cur);
            for(int course : list){
                indegree[course]--;
                if(indegree[course] == 0) q.offer(course);
            }
        }

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] != 0) return false;
        }

        return true;
    }
}
