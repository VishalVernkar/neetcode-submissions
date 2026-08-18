class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return List.of(0);
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        int[] degree = new int[n];

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i  < n; i++){
            if(degree[i] == 1) q.offer(i);
        }

        int remainigNodes = n;
        while(remainigNodes > 2){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int node = q.poll();
                remainigNodes--;
                for(int neig : graph.get(node)){
                    degree[neig]--;
                    if(degree[neig] == 1) q.offer(neig);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        res.add(q.poll());
        if(!q.isEmpty()) res.add(q.poll());

        return res;
    }


}

// using kahn's algortihm - peel of the leaves - level by level
// build the undirected graph
// get the degree
// use queu = popluate with leaf edges
// pop each leaf edges - update the degree - updtae the new leaf edges
// once the nodes remaining are < 2 - we have the centre one or two nodes