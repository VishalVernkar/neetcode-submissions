class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int c = 0; c < n; c++){
            if(board[0][c] == 'O') q.offer(new int[]{0, c});
            if(board[m - 1][c] == 'O') q.offer(new int[]{m - 1, c});
        }

        for(int r = 1; r < m - 1; r++){
            if(board[r][0] == 'O') q.offer(new int[]{r, 0});
            if(board[r][n - 1] == 'O') q.offer(new int[]{r, n - 1});
        }

        int[][] dirs = new int[][]{{-1, 0},{1, 0},{0, -1},{0, 1}};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            board[cur[0]][cur[1]] = 'T';
            for(int[] dir : dirs){
                int r = cur[0] + dir[0];
                int c = cur[1] + dir[1];
                if(r < 0 || c < 0 || r >= m || c >= n || board[r][c] != 'O') continue;
                q.offer(new int[]{r, c});
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}

// we start from the edge 
// we go to every 'O' form that point and mark it as not surounded
// we can use BFS here.
