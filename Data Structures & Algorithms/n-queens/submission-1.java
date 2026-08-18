class Solution {
    boolean[] cols;
    boolean[] posDia;
    boolean[] negDia;
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        cols = new boolean[n];
        posDia = new boolean[2*n];
        negDia = new boolean[2*n];
        char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row, '.');
        }
        dfs(n, board, 0);
        return res;
    }

    private void dfs(int n, char[][] board, int row){
        if(row == n){
            List<String> list = new ArrayList<>();
            for(char[] line : board){
                list.add(new String(line));
            }
            res.add(list);
            return;
        }

        for(int col = 0; col < n; col++){
            if(cols[col] || negDia[row - col + n] || posDia[row + col]) continue;
            cols[col] = true;
            negDia[row - col + n] = true;
            posDia[row + col] = true;
            board[row][col] = 'Q';
            dfs(n, board, row + 1);
            board[row][col] = '.';
            cols[col] = false;
            negDia[row - col + n] = false;
            posDia[row + col] = false;
        }
    }
}

// I want to do it right
// do it with right effort 
// i want to solve it with speed

// placing queens
//   0 1 2 3
// 0 x  
// 1   x   x 
// 2     x 
// 3   x   x 

// col[2]
// row[2]
// diag[r - c]
// diag[r + c]