class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                int num = board[i][j] - '0' - 1;
                int box = 3 * (i/3) + j/3;
                if(rows[i][num] || cols[j][num] || boxes[box][num]){
                    return false;
                }
                rows[i][num] = cols[j][num] = boxes[box][num] = true;
            }
        }
        return true;
    }
}
// 10:16

// using boolean arrray
// for row
// for col
// for box

// box idx
// 3 * i/3 + j/3
//             0 1 2 3 4 5 6 7 8
// 3 * i/3     0 0 0 3 3 3 6 6 6
//     j/3     0 0 0 1 1 1 2 2 2

// num - char - '0'
// row - 0
// col - 1
// box - box index 