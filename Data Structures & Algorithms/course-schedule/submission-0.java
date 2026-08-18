class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>()); // add empty list to for every course
        }

        // complete course b -> to complete course a
        // b -> list of course that can be completed after b
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]); // b → a
        }

        // sate of num of courses
        int[] state = new int[numCourses]; // 0,1,2

        // for each course dfs
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, state, i)) return false;
        }

        return true;
    }

    // node  - course number
    private boolean dfs(List<List<Integer>> graph, int[] state, int node) {
        if (state[node] == 1) return false; // cycle // if I'm here - it means I'm again visiting it. 
        if (state[node] == 2) return true;

        state[node] = 1; // visiting -> waiting for other course to complete

        for (int nei : graph.get(node)) {
            if (!dfs(graph, state, nei)) return false;
        }

        state[node] = 2;  // course completed
        return true;
    }
}