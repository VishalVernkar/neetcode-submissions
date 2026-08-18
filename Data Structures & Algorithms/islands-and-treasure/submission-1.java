class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0) q.offer(new int[]{i , j});
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

            for(int[] dir : directions){
                int r = cur[0] + dir[0];
                int c = cur[1] + dir[1];

                if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == Integer.MAX_VALUE){
                    grid[r][c] = grid[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{r, c});
                }
            } 
        }
    }
}

// 7:25

// Question


// intuition
// instead of searching distance of treasusre from each point 
// it takes (m x n)^2 - compelxiety - which takes time

// we can expand fron the trasure 0 - to all the nearest land
// we can do it in m x n using BFS
// using DFS - is not feasible here - because DFS goes all the way to deep - we cannot control it to stop
// where as BFS - takes one step at a time


// algo
// when we encounter a tresure
// we add it to queue
// through
// each treasaure adjacent lands are updated - then they are added to ques
// as other treasue are in the que the - closer ones are always updated first