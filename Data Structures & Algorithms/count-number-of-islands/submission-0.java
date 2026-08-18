class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int islands = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    islands++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int r, int c, boolean[][] visited){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0' || visited[r][c]) return;

        visited[r][c] = true;
        dfs(grid, r + 1, c, visited);
        dfs(grid, r - 1, c, visited);
        dfs(grid, r, c + 1, visited);
        dfs(grid, r, c - 1, visited);
    }
}

// 11:57
// Question
// Count the number of islands in the grid

// I can use a boolean array
// for every land I find In grid - I dfs - update - the visited boolean 
// and contnue and only start dfs if it is not visted and it == 1