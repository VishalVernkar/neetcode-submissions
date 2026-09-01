class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                int num = board[i][j] - '0' - 1;
                int boxIdx = 3 * (i/3) + j/3;
                if(rows[i][num] || cols[j][num] || boxes[boxIdx][num]) return false;
                rows[i][num] = cols[j][num] = boxes[boxIdx][num] = true;
            }
        }
        return true;
    }
}

// using boolean array
// row index array
// col index array
// box index array

// box index => 
// 00 01 02 03
// 10 11 12
// 20 21 22

// 30

// 3 * i / 3 + j / 3

// 
