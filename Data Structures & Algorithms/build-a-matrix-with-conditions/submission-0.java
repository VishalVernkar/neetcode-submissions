class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rowOrder = topologicalSort(k, rowConditions);
        if(rowOrder[k - 1] == 0) return new int[0][0];
        int[] colOrder = topologicalSort(k, colConditions);
        if(colOrder[k - 1] == 0) return new int[0][0];

        int[] colIdx = new int[k + 1];
        for(int i = 0; i < k; i++){
            colIdx[colOrder[i]] = i;
        }

        int[][] kmatrix = new int[k][k];
        for(int i = 0; i < k; i++){
            kmatrix[i][colIdx[rowOrder[i]]] = rowOrder[i];
        }

        return kmatrix;
    }

    private int[] topologicalSort(int k, int[][] conditions){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= k; i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[k+1];
        for(int[] condition : conditions){
            graph.get(condition[0]).add(condition[1]);
            indegree[condition[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= k; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        int[] res = new int[k];
        int ord = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            res[ord++] = cur;
            for(int neig : graph.get(cur)){
                indegree[neig]--;
                if(indegree[neig] == 0) q.offer(neig);
            }
        }

        return res;
    }
}

// using kahn's toplogical sort

// we can get the placements of the k elements
// consider both conditions as graph
// based on topological traversal order of them gives the index in - 0 to k-1 for each element
// we take row index from rowCOnd
// -- from col cond 

// algo
// build a directed graph for both
// get indegree
// load in the queue nodes having no incomnind eges 
// relax them one by one get the list