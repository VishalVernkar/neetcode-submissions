class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] p : prerequisites){
            graph.get(p[0]).add(p[1]);
        }

        int[] state = new int[numCourses];

        for(int course = 0; course < numCourses; course++){
            if(!dfs(graph, state, course)) return false;
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int[] state, int course){
        if(state[course] == 1) return false;
        if(state[course] == 2) return true;

        state[course] = 1;
        for(int mustCrs : graph.get(course)){
            if(!dfs(graph, state, mustCrs)) return false;
        }
        state[course] = 2;
        return true;
    }
}

// 6:28

// Question
// given couses
// return if it can be completed based on the restrictions
// restriction - book b must be completed before book a

// this is a graph problem - where each book is connected to - completion of other books
// the course can't be completed - if there is a cycle 
// ex : 1 -> 2 -> 3, but 3 -> 1 => which is a cycle and we cannot complete it

// steps
// we can detect the cycle through DFS or BFS/Kahn's algorighm
// dfs
// we will first create a graph 
// each index -> list of course to be completed before
// we use state[] to track the status of course - while traversing graph path
// 0 -> unvisited
// 1 -> visiting // if we reach this state for a course again - it means - it is cycle - and return false;
// 2 -> completed
