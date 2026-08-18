class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i, j});
                }
            }
        }
        int[][] dirs = new int[][]{{-1, 0}, {+1, 0}, {0, -1}, {0, +1}}; 
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int[] dir:dirs){
                int i = cur[0] + dir[0];
                int j = cur[1] + dir[1];
                if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == -1 || grid[i][j] != Integer.MAX_VALUE) continue;
                q.offer(new int[]{i, j});
                grid[i][j] = grid[cur[0]][cur[1]] + 1;
            }
        }
    }
}
// dfs
// start from each land 
// from each cell I can go in four directions - once i find the treasure from a cell
// I return - from all the directions I keep the shortest ones
// 

// a - 2
// start ffrom each treasure - updtae the nearest cell 
// usign BFS
