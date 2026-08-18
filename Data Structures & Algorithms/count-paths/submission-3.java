class Solution {
    int[][] dp;
    int m, n;
    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        dp = new int[m][n];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i], -1);
        }

        dp[m-1][n-1] = 1;

        dfs(0, 0);

        return dp[0][0];

    }

    private int dfs(int r, int c){
        if(r >= m || c >= n || r < 0 || c < 0) return 0;
        if(dp[r][c] != -1) return dp[r][c];

        dp[r][c] = dfs(r + 1, c) + dfs(r, c + 1);

        return dp[r][c];
    }
}

// 
