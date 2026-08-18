class Solution {
    int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        int top = dfs(grid, i - 1, j);
        int bottom = dfs(grid, i + 1, j);
        int right = dfs(grid, i, j - 1);
        int left = dfs(grid, i, j + 1);

        return 1 + top + bottom + left + right;
    }
}
