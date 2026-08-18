class Solution {
    int total = 0;
    public int totalNQueens(int n) {

        boolean[] col = new boolean[n];
        boolean[] mainDiag = new boolean[2*n - 1];
        boolean[] antiDiag = new boolean[2*n - 1];

        backtrack(n, 0, col, mainDiag, antiDiag);
        return total;
    }

    private void backtrack(int n, int r, boolean[] col, boolean[] mainDiag, boolean[] antiDiag){
        if(r == n){
            total++;
            return;
        }

        for(int c = 0; c < n; c++){
            int mainD = r - c + n - 1;
            int antiD = r + c;
            if(col[c] || mainDiag[mainD] || antiDiag[antiD]) continue;
            col[c] = mainDiag[mainD] = antiDiag[antiD] = true;
            backtrack(n, r + 1, col, mainDiag, antiDiag);
            col[c] = mainDiag[mainD] = antiDiag[antiD] = false;
        }
    }


}