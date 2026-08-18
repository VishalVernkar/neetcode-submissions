class Solution {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 1){
                    res += 4;
                    if(r > 0 && grid[r - 1][c] == 1) res-=2;
                    if(c > 0 && grid[r][c - 1] == 1) res-=2;
                }
            }
        }
        return res;
    }
}
// 6:11

// Question
// get the perimeter of the island

// steps
// bfs
// for each land we find - we check boundaries and add 1 to it