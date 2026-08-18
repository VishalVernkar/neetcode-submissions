class WordDictionary {
    private class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode();
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }


    private boolean dfs(String word, int i, TrieNode cur){
        if(cur == null) return false;
        if(i == word.length()) return cur.isEnd;
        char c = word.charAt(i);
        if(c == '.'){
            for(TrieNode node : cur.children){
                if(dfs(word, i + 1, node)) return true;
            }
            return false;
        } else {
            return dfs(word, i + 1, cur.children[c - 'a']);
        }
    }
}
