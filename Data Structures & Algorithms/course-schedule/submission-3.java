class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] edge : prerequisites){
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            count++;
            for(int neig : graph.get(cur)){
                indegree[neig]--;
                if(indegree[neig] == 0) q.offer(neig);
            }
        }

        return count == numCourses;
    }
}

// 
