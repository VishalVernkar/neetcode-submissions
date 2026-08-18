class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> atlQ = new LinkedList<>();

        int m = heights.length, n = heights[0].length;

        for(int i = 0; i < n; i++){
            pacQ.offer(new int[]{0, i});
            atlQ.offer(new int[]{m - 1, i});
        }

        for(int i = 0; i < m; i++){
            pacQ.offer(new int[]{i, 0});
            atlQ.offer(new int[]{i, n - 1});
        }

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        int[][] dirs = new int[][]{{-1, 0},{1, 0},{0, -1},{0, 1}};
        while(!pacQ.isEmpty()){
            int[] cur = pacQ.poll();
            pac[cur[0]][cur[1]] = true;
            for(int[] dir : dirs){
                int r = cur[0] + dir[0];
                int c = cur[1] + dir[1];
                if(r < 0 || c < 0 ||  r >= m || c >= n || pac[r][c] == true || heights[r][c] < heights[cur[0]][cur[1]]) continue;
                pacQ.offer(new int[]{r, c});
            }
        }

        while(!atlQ.isEmpty()){
            int[] cur = atlQ.poll();
            atl[cur[0]][cur[1]] = true;
            for(int[] dir : dirs){
                int r = cur[0] + dir[0];
                int c = cur[1] + dir[1];
                if(r < 0 || c < 0 ||  r >= m || c >= n || atl[r][c] == true || heights[r][c] < heights[cur[0]][cur[1]]) continue;
                atlQ.offer(new int[]{r, c});
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pac[i][j] && atl[i][j]) res.add(List.of(i, j));
            }
        }

        return res;
    }

    
}

// dfs on each cell to check if it reaches the pacific side and atlantic side
// for pacific - r < 0 and c < 0
// for atlantic - r == n and c == n

// start from edgees
//. BFS
// 
