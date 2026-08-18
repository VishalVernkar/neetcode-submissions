class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] dist = new int[m][n];

        for(int[] row : dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0, 0, 0});
        
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            int diff = cur[0];
            int r = cur[1];
            int c = cur[2];
            if(r == m - 1 && c == n - 1) return diff; 
            if(dist[r][c] < diff) continue;
            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                int newDiff = Math.max(diff, Math.abs(heights[r][c] - heights[nr][nc]));
                if(newDiff < dist[nr][nc]){
                    minHeap.offer(new int[]{newDiff, nr, nc});
                    dist[nr][nc] = newDiff;
                }
            }
        }
        
        return 0;
    }
}

// using dijkstra's algo
// using heap
// feed the path max path effort upto current path - feed only if the new effort is less than existing one
// pop the min one and continue