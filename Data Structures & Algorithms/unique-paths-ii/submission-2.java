class Solution {
    int[][] dp;
    int m;
    int n;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }
        if(obstacleGrid[m - 1][n - 1] == 1) return 0;
        dp[m - 1][n - 1] = 1;
        dfs(obstacleGrid, 0, 0);
        return (dp[0][0] == -1)? 0 : dp[0][0];
    }
    
    private int dfs(int[][] obstacleGrid, int r, int c){
        if(r >= m || c >= n || obstacleGrid[r][c] == 1) return 0;
        if(dp[r][c] != -1) return dp[r][c];

        dp[r][c] = dfs(obstacleGrid, r + 1, c) + dfs(obstacleGrid, r, c + 1);

        return dp[r][c]; 
    }
    
}

// using dfs
// skipping the encountered - obstacle