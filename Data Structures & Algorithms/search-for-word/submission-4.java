class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int idx){
        if(idx == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#' || board[i][j] != word.charAt(idx)) return false;

        char temp = board[i][j];
        board[i][j] = '#';
        boolean top = dfs(board, i - 1, j, word, idx + 1);
        boolean bottom = dfs(board, i + 1, j, word, idx + 1);
        boolean left = dfs(board, i, j - 1, word, idx + 1);
        boolean right = dfs(board, i, j + 1, word, idx + 1);
        board[i][j] = temp;

        return top || bottom || left || right;
    }
}

//  search the word
// we use  a boolean array to avoid visted part or we temporarily replace the char with "#" to avaoid revisitng
// we try every path possible to get the res

// we start from each index - if the first char is found we dfs
// 
