class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0, k});   

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] time : times){
            graph.get(time[0]).add(new int[]{time[2], time[1]});
        }

        int minTime = 0; 
        Set<Integer> visited = new HashSet<>();
        while(!minHeap.isEmpty() && visited.size() != n){
            int[] cur = minHeap.poll();
            int time = cur[0];
            int node = cur[1];
            if(visited.contains(node)) continue;
            visited.add(node);
            minTime = Math.max(minTime, time);
            for(int[] neig : graph.get(node)){
                if(visited.contains(neig)) continue;
                minHeap.offer(new int[]{time + neig[0], neig[1]});
            }
        }

        return (visited.size() == n)? minTime : -1;
    }
}

// using greedy - 

// Dijkstra - min heap - closest path
// visit every edge - once - using stack and minheap graph
// create edges - using min heap - closest path

// BFS - minHeap
// we will start form k
// with cost 0
// we offer its neigs to the min heap
// we pop the closest time
// then from that node - we takes its neig and add the current cost to it
// offer to heap once we have visited all the nodes - we return