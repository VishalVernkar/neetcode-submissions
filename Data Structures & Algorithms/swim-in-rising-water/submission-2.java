class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = new int[][]{{1, 0},{-1, 0},{0, 1},{0, -1}};

        minHeap.offer(new int[]{grid[0][0], 0, 0});
        while(!minHeap.isEmpty()){
            int[] cur = minHeap.poll();
            int r = cur[1];
            int c = cur[2];
            int t = cur[0];
            if(r == m-1 && c == n - 1) return t;
            if(visited[r][c]) continue;
            visited[r][c] = true;
            for(int[] dir : dirs){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr < 0 || nc < 0 || nr >= m || nc >=m || visited[nr][nc]) continue;
                minHeap.offer(new int[]{Math.max(t, grid[nr][nc]), nr, nc});
            }
        }
        
        return 0;
    }
}

// using dijkstra's algorithm
// we have to update the max time it took in the path 
// we have to choose min among the max paths
