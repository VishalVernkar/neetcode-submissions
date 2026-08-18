class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int right = (j + 1 < n)? grid[i][j + 1] : Integer.MAX_VALUE;
                int down = (i + 1 < m)? grid[i + 1][j] : Integer.MAX_VALUE;
                if(right == Integer.MAX_VALUE && down == Integer.MAX_VALUE) continue;
                grid[i][j] += Math.min(down, right);
            }
        }

        return grid[0][0];
    }
}

// minimum path sum
// to reach to this point take the best path
// choose the minimum among two choices we have