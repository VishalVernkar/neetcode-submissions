class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] p : prerequisites){
            graph.get(p[0]).add(p[1]);
        }

        int[] state = new int[numCourses];

        int[] idx = new int[]{0};
        for(int course = 0; course < numCourses; course++){
            if(!dfs(graph, state, course, res, idx)) return new int[0];
        }
        return res;
    }

    private boolean dfs(List<List<Integer>> graph, int[] state, int course, int[] res, int[] idx){
        if(state[course] == 1) return false;
        if(state[course] == 2) return true;

        state[course] = 1;
        for(int mustCourse : graph.get(course)){
            if(!dfs(graph, state, mustCourse, res, idx)) return false;
        }

        state[course] = 2;
        res[idx[0]++] = course;
        return true;
    }
}

// 7:13 - 7:30

// Question
// This is similar to previous question
// Here I have to also capture the list of course that are completed in order

// steps
// we can use the saem prvious steps - we'll also have a list - to store the courses

// algo
// create a graph - with emptylist - populate with prerequi..
// create a state array
// dfs on each course - if it return false return empty array
// else return res at the end;

// numCourses=3
// prerequisites=[[1,0]]
// 1 -> 0
