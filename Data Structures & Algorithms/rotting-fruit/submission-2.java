class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length == 1 && grid[0].length == 1){
            if(grid[0][0] == 0) return 0;
            if(grid[0][0] == 1) return -1;
            if(grid[0][0] == 2) return 0;

        }

        Queue<int[]> q = new LinkedList<>();
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) q.offer(new int[]{i, j});
            }
        }

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        int mins = 0;
        while(!q.isEmpty()){
            mins++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                for(int[] dir : dirs){
                    int r = cur[0] + dir[0];
                    int c = cur[1] + dir[1];
                    if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1){
                        grid[r][c] = 2;
                        q.offer(new int[]{r, c});
                    }
                }
            }
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) return -1;
            }
        }


        return (mins == 0)? 0 : mins - 1;
        
    }


}

// 17:20 - 17:40

// Question 
// return the min to - get the complete bananas to rot


// steps
// This is similar to -> treasure and gates 
// we start from trasaure -> update adjacent cell its distance
// we use BFS for this
// for rotten banana we start BFS
// we offer each rotten banana to queue
// we take first one update the adjacent  to rott
// add these to queue again


// How do I determine the miniute
// I have to track BFS level
