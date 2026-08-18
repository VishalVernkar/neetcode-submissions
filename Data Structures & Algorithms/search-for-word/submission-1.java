class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(findWord(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findWord(char[][] board, String word, int idx, int row, int col){
        if(idx == word.length()) return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if(board[row][col] != word.charAt(idx)){
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#'; // visited


        boolean up = findWord(board, word, idx + 1, row - 1, col);
        boolean left = findWord(board, word, idx + 1, row, col - 1);
        boolean right = findWord(board, word, idx + 1, row, col + 1);
        boolean down = findWord(board, word, idx + 1, row + 1, col);

        board[row][col] = temp; // backtrack

        return up || left || right || down;
    }
}
// this code doen't take care of already visited cell
// i need a boolean array for it - for every index 
// enough I might be able to solve with boolean array - but I should look for better solution so - I'll go look for solution

// 14:10 - 14:30

// Question

// check if the given word is present in the 2d array
// must be formed in horizontal of vertical neighboring cells

// brute force
// get all the combinations of a word to be formed

// how can I do this 
// what are all the possible words I can form 

// from 
// i = 0
// each cel can connect to adjacent cell through left, right, up, down, 

// I search for first char - then from that char recursively search for next char

// recursive - char to search, idx of current char, word, 


// Debug - 5m
//[["A","B","C","E"],
// ["S","F","C","S"],
// ["A","D","E","E"]]






















// Do it in right form