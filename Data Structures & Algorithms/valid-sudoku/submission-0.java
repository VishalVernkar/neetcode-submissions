class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> row;
        Set<Character> col;
        Set<Character> box;
        for(int i=0; i<9; i++){
            row = new HashSet<>();
            col = new HashSet<>();
            box = new HashSet<>();
            int boxRow,boxCol;
            for(int j=0; j<9; j++){
                if(board[i][j]!='.'){
                    if(!row.add(board[i][j])) return false;
                }
                if(board [j][i]!='.'){
                    if(!col.add(board[j][i])) return false;
                }
                boxRow= (j/3) + ((i/3) * 3);
                boxCol= (j%3) + ((i%3) * 3);
                if(board[boxRow][boxCol] != '.'){
                    if(!box.add(board[boxRow][boxCol])) return false;
                }
            }
        }
        return true;
    }
}
