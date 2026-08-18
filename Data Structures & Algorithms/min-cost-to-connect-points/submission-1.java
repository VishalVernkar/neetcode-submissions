class Solution {
    public int minCostConnectPoints(int[][] points) {
        if(points.length == 1) return 0;
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for(int i = 0; i < points.length; i++){
            for(int j = i + 1; j < points.length; j++){
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                graph.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[]{distance, j});
                graph.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[]{distance, i});
            }
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0, 0});
        Set<Integer> visited = new HashSet<>();

        int cost = 0;
        while(visited.size() != points.length){
            int[] cur = minHeap.poll();
            if(visited.contains(cur[1])) continue;
            int dist = cur[0];
            int point = cur[1];
            cost += dist;
            visited.add(point);
            for(int[] neig : graph.get(point)){
                if(visited.contains(neig[1])) continue;
                minHeap.offer(neig);
            }
        }
        return cost;
    }
}

// using prim's algorithm - greedy appraoch
// pick the closest points

// bfs
// use heap 
// first create a graph - every edge from one point to every other edge 
// offer one point
// poll each point - add its cost
// from that point - add all the next points to min heap
// 
