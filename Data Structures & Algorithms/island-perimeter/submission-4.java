class Solution {
    public int islandPerimeter(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0){
            return 1;
        } else if(grid[i][j] == -1) {
            return 0;
        }

        int temp = grid[i][j];
        grid[i][j] = -1;
        int top = dfs(grid, i - 1, j);
        int bottom = dfs(grid, i + 1, j);
        int left = dfs(grid, i, j - 1);
        int right = dfs(grid, i, j + 1);
        // grid[i][j] = temp;

        return top + bottom + left + right;
    }
}

//  this is similar to find the word from - backtraking

// here I need to start dfs from place once the land is found
// go left - up - right - down 
// if we hit water or boundry - we returun 1
// if we hit block - we rreturn 0 - and continue search from there
// else we add return one - with res