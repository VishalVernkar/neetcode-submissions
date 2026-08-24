class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.') continue;
                int num = board[i][j] - '0' - 1;
                int boxIdx = i/3 * 3 + j/3;
                if(row[i][num] || col[j][num] || box[boxIdx][num]) return false;
                row[i][num] = col[j][num] = box[boxIdx][num] = true;
            }
        }
        return true;
    }
}

// valid sodoku
// row col box not to have duplicate number
// 

// i j
//   0 1 2 3 4
// 0 1 2 3
// 1 4 5 6
// 2 7 8 9
// 3
// 4

// using boolean array
// row duplicates and col duplicates
// 2d array 
// - m - row number - 
// - n - the number

// box num
//   0 1 2 3 4 5 6 7 8 
// 0 
// 1 
// 2 
// 3 
// 4 
// 5
// 6 
// 7 
// 8

// 00 01 02 
// 10 11 12
// 20 21 22
// 

// 03 04 05
// 13 14 15
// 23 24 25

// 30 31 32
// 40 41 42
// 50 51 52

// 3i/3 + j/3
