class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 1) fresh++;
                else if(grid[r][c] == 2) q.offer(new int[]{r, c});
            }
        }

        int[][] dirs = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        int mins = 0;
        while(fresh > 0 && !q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                for(int[] dir : dirs){
                    int r =cur[0] + dir[0];
                    int c =cur[1] + dir[1];

                    if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 1){
                        grid[r][c] = 2;
                        fresh--;
                        q.offer(new int[]{r, c});
                    }
                }
            }
            mins++;
        }

        return (fresh == 0)? mins : -1;
    }
}

// Question
// find the mins it takes to get all the bananas to rott
// if all can't rott return -1

// steps 
// we can use BFS - for it 
// This is multi source BFS
// we start from each rotten banana
// spread through adjacent ones
// we increment mins after each level
// when threre are no fresh bananase left 
// or rotten bananas cannot rott fresh ones anymore we stop
// if there are still fresh banans left - we return -1 else mins

// algo
// we collecnt pos of each rotten banana - in q
// we also keep count of fresh banana present
// we start bfs on the queue
// we process till the cureent level is processed
// if we find a fresh banana - we rott it  - add it to queue
// we decrement fresh count
// we stop loop if fresh is <= 0
// return res