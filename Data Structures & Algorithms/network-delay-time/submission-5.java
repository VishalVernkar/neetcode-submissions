class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] time : times){
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0, k});
        dist[k] = 0;

        int res = 0;
        int visitedCount = 0;

        while(!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            int effort = cur[0];
            int node = cur[1];
            if (effort > dist[node]) continue;

            // We just finalized the shortest path to a new node!
            // Since the heap pops in increasing order, 'effort' is our current max.
            res = effort; 
            visitedCount++;
    
            // Early exit: If we've reached all 'n' nodes, we are completely done.
            if (visitedCount == n) return res;

            for(int[] target : graph.get(node)){
                if(dist[target[0]] <= target[1] + effort) continue;
                minHeap.offer(new int[]{target[1] + effort, target[0]});
                dist[target[0]] = target[1] + effort;
            }
        }

        // System.out.println(Arrays.toString(dist));
        // int res = Integer.MIN_VALUE;
        // for(int i = 1; i <=n; i++){
        //     if(dist[i] == Integer.MAX_VALUE) return -1;
        //     res = Math.max(res, dist[i]);
        // }

        // return (res == Integer.MIN_VALUE)? -1 : res;
        return -1;
    }
}

// dijkstra's algorithm
// go with min effort path
