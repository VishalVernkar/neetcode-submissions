class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for(int c = 0; c < n; c++){
            if(board[0][c] == 'O') dfs(board, visited, 0, c);
            if(board[m-1][c] == 'O') dfs(board, visited, m - 1, c);
        }

        for(int r = 1; r < m - 1; r++){
            if(board[r][0] == 'O') dfs(board, visited, r, 0);
            if(board[r][n-1] == 'O') dfs(board, visited, r, n - 1);
        }

        // for(boolean[] visit : visited){
        //     System.out.println(Arrays.toString(visit));
        // }

        for(int r = 0; r < m; r++){
            for(int c = 0; c < n; c++){
                if(board[r][c] != 'X' && !visited[r][c]) board[r][c] = 'X';
            }
        }

    }

    private void dfs(char[][] board, boolean[][] visited, int r, int c){
        visited[r][c] = true;
        int[][] dirs = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        for(int[] dir : dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nc >= 0 && nr >= 0 && nc < board[0].length && nr < board.length && !visited[nr][nc] && board[nr][nc] == 'O'){
                dfs(board, visited, nr, nc);
            }
        }
    }
}


// 20:35 - 20:55

// I don't need to think that I won't be able 
// the simple and best thing I can do is -> figure out how to solve

// Question
// I'm not clear about this 
// the cell can be captured if it is surronded by more than two x cells and it should not be in bpundary



// steps 
// take all the O's from 2nd row to n-2 col

// from each o -> cehck it is surroned by O in more than 2 directions

// we can use same approach as previous 
// we start from 0 from the edge
// if any 0 encounterd -> by chceking adjacent we update it as true
// then at the end we update only true cells if it is not x

// In:
// [["O","X","X","O","X"],
//  ["X","O","O","X","O"],
//  ["X","O","X","O","X"],
//  ["O","X","O","O","O"],
//  ["X","X","O","X","O"]]

// //  out:
// [["O","X","X","O","X"],
//  ["X","X","X","X","O"],
//  ["X","X","X","O","X"],
//  ["O","X","O","O","O"],
//  ["X","X","O","X","O"]]

