class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(findChar(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean findChar(char[][] board, String word, int idx, int row, int col){
        if(idx == word.length()) return true;
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(idx)) return false;

        char temp = board[row][col];
        board[row][col] = '#';
        boolean res =   findChar(board, word, idx + 1, row - 1, col) ||
                        findChar(board, word, idx + 1, row + 1, col) ||
                        findChar(board, word, idx + 1, row, col - 1) ||
                        findChar(board, word, idx + 1, row, col + 1);
        board[row][col] = temp;

        return res;
    }
}

// 6:22 - 6:42

// Question
// see if the given word - exists in 2d array - the characters should be in a path

// Steps
// if I find char - the next possible char can be found in up, down, left, right
// so for every char I find I recursively - call to find in these directions

// algo 
// findchar
// if the current search indx of word == len of word - we found the res
// else
// we see the next char we are looking for is present - in the current index - 
// if not return false
// else, 
// we look for next char in all directions recursively

// in main function
// we traverse the whole - search for first char - if found we call the recursive function 
