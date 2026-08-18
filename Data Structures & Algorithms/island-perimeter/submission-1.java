class Solution {
    public int islandPerimeter(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) {
                    return perimeter(grid, i, j);
                }
            }
        }
        // System.out.println(i + j);
        return 0;
    }

    private int perimeter(int[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0){
            return 1;
        } 
        if(grid[r][c] == -1) return 0;
        grid[r][c] = -1;
        int up = perimeter(grid, r - 1, c);
        int down = perimeter(grid, r + 1, c);
        int right = perimeter(grid, r, c + 1);
        int left = perimeter(grid, r, c  - 1);
        //grid[r][c] = 1;
        return up + down + right + left;

    }
}