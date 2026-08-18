class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length, count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        if(count == 0) return 0;

        int min = 0;
        int[][] dirs = new int[][]{{-1, 0},{1, 0},{0, -1},{0, 1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                for(int[] dir : dirs){
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];
                    if(r < 0 || c < 0 || r >= m || c >= n || grid[r][c] != 1) continue;
                    q.offer(new int[]{r, c});
                    grid[r][c] = 2;
                    count--;
                }
            }
            min++;
        }
        return (count == 0)? min - 1 : -1;
    }
}

// BFS
// return the level of BFS
