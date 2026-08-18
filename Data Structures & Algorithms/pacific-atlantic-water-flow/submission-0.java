class Solution {
    int m = 0;
    int n = 0;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
 
        for(int r = 0; r < m; r++){
            dfs(heights, pacific, r, 0);
            dfs(heights, atlantic, r, n - 1);
        }

        for(int c = 0; c < n; c++){
            dfs(heights, pacific, 0, c);
            dfs(heights, atlantic, m - 1, c);
        }


        List<List<Integer>> res = new ArrayList<>();
        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(pacific[r][c] && atlantic[r][c]) res.add(Arrays.asList(r, c));
            }
        }

        return res;

    }

    private void dfs(int[][] heights, boolean visited[][], int r, int c){
        visited[r][c] = true; //as we reach here only if it water can reach from this cell so we update it as true
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];

            if(nr >= 0 && nc >= 0 && nr < m && nc < n && !visited[nr][nc] && heights[nr][nc] >= heights[r][c]){
                dfs(heights, visited, nr, nc);
            }
        } 
    }
}

// 5:52 - 6:00

// Question
// find the cells - where rain water can reach from them can reach to both pacific and atlantic ocean


// steps
// Instead checking each cell if the water can reach to both ocean
// go with reverse approach
// check if from each cells at the ocean bonadary - the rain water can flow to the ocean
// we move to adjacent cells - if it is >= current cell
// we do it on the edjes of pacific and edges of atlantic sperately
// if both are true for each cell we add them to res

// algo
// we can go with dfs or bfs
// dfs
// create a boolean array for both paicifc and atlantic - to update if water from cell can come to ocean
// dfs from each cell on edge and update on these boolean array
// then cehck for each cell if bothe the values are true





// what I can do to improve here
// finish analyzing the problem - in 5 - 10mins
// start the solution in 10 mins

// In this problem it was problem statement was wrong - and took time to undersatand