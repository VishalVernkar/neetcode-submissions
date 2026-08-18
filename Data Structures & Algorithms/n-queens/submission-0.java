class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] mainDiag = new boolean[2*n - 1]; // as their are 2*n - 1 no of diagonals
        boolean[] antiDiag = new boolean[2*n - 1];

        char[][] board = new char[n][n];
        for(char[] row : board) Arrays.fill(row, '.');

        List<List<String>> res = new ArrayList<>();

        backtrack(n, 0, col, mainDiag, antiDiag, board, res);

        return res;
     }

     private void backtrack(int n, int r, boolean[] col, boolean[] mainDiag, boolean[] antiDiag, char[][] board, List<List<String>> res){
        if(r == n){
            res.add(construct(board));
            return;
        }

        for(int c = 0; c < n; c++){
            int mainD = r - c + n - 1;
            int antiD = r + c;
            if(col[c] || mainDiag[mainD] || antiDiag[antiD]) continue;
            board[r][c] = 'Q';
            col[c] = mainDiag[mainD] = antiDiag[antiD] = true;
            backtrack(n, r + 1, col, mainDiag, antiDiag, board, res);
            board[r][c] = '.';
            col[c] = mainDiag[mainD] = antiDiag[antiD] = false;
        }
     }

     private List<String> construct(char[][] board){
        List<String> list = new ArrayList<>();
        for(char[] row : board) list.add(new String(row));
        return list;
     }
}

// 6:48 - 7:03

// Question

// place the n queens in a nxn board in such a way that - no queen are in attack path of each other

// steps 
// we can use boolean array to track bloacked board boxes
// we can place each queen row wise - so ne need to track conflicts row wise
// we can use boolean array for columns
// we can use boolean array for diagonal - topleft to bottom right
// as their r - c is always constant we can use that
// we can use boolean array for anti diagonal - top right to bottom left
// as their r + c is always constant we can use that
// we can use a char board to do the place ment 
// conver it to list at the end

//


