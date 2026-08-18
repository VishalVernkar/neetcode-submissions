class Solution {
    int[][] dirs = new int[][]{{-1, 0},{1, 0},{0, -1},{0, 1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> atlQ = new LinkedList<>();

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        for(int c = 0; c < n; c++){
            pacQ.offer(new int[]{0, c});
            atlQ.offer(new int[]{m - 1, c});
        }

        for(int r = 0; r < m; r++){
            pacQ.offer(new int[]{r, 0});
            atlQ.offer(new int[]{r, n - 1});
        }

        bfs(heights, pacQ, pac, m, n);
        bfs(heights, atlQ, atl, m, n);

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j= 0; j < n; j++){
                if(pac[i][j] && atl[i][j]){
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    private void bfs(int[][] heights, Queue<int[]> q, boolean[][] toOcean, int m, int n){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            toOcean[cur[0]][cur[1]] = true;
            for(int[] dir : dirs){
                int r = cur[0] + dir[0];
                int c = cur[1] + dir[1];
                if(r < 0 || c < 0 || r >= m || c >= n || toOcean[r][c] || heights[r][c] < heights[cur[0]][cur[1]]) continue;
                q.offer(new int[]{r, c});
            }
        }
    }
}

// BFS using queue
// all the edge gets water to ocean
// start from the edges - see if the adjacent ones - are peak - then bfs on them
// we bfs on both edges - 
// if the edges get water from both sides - then add it to res
