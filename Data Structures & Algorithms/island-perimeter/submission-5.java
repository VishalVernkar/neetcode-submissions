class Solution {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    res += 4;
                    if(i > 0 && grid[i - 1][j] == 1){
                        res -= 2;
                    }

                    if(j > 0 && grid[i][j - 1] == 1){
                        res -= 2;
                    }
                }
            }
        }
        return res;
    }
}

// A 1
// each land has a perimeter of 4
// if we encountr a block on top and left - subtract 2 from it

// 