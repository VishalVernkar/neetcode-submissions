class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
        int[][] grid = new int[m + 1][n + 1];
        grid[m - 1][n - 1] = 1;
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(obstacleGrid[i][j] != 1){
                    grid[i][j] += grid[i + 1][j] + grid[i][j + 1];
                }
            }
        }

        return grid[0][0];
    }
}

// cannot take the obstacle path