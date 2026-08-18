class Solution {

    private class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    private void addWord(TrieNode root, String word){
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            int i = c - 'a';
            if(cur.children[i] == null) cur.children[i] = new TrieNode();
            cur = cur.children[i];
        }
        cur.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        for(String word : words) addWord(root, word);

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, root, i, j, res);
            }
        }

        return res;
        
    }

    private void dfs(char[][] board, TrieNode cur, int r, int c, List<String> res){
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == '#') return;
        char ch = board[r][c];
        cur = cur.children[ch - 'a'];

        if(cur == null) return;
        if(cur.word != null){
            res.add(cur.word);
            cur.word = null;
        }

        board[r][c] = '#';

        dfs(board, cur, r + 1, c, res);
        dfs(board, cur, r - 1, c, res);
        dfs(board, cur, r, c + 1, res);
        dfs(board, cur, r, c - 1, res);

        board[r][c] = ch;
    }
}

// I feel lazy to write
// I want to be able to write the code spontaneously
// I need to practive more
// how can I improve it?
// focus on key board while writing

// 5:03 - 5:13

// Question
// find the words

// Intiution
// instead of trying each word for each char from the boards
// we can use trie of words -> on each char from board
// if any exists we start the search in trie

// algo
// for each char in board
// if it match in trie
// start search
// using dfs
// if not a match or null - return 
// if it is end of word - add word to res
// then look for in all directions











// I can find things to be good at this
// I can improve on time I solve
// so the right form is - 
// be active
// focus on this

//  warmup for now
