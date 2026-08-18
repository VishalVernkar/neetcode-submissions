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
            // System.out.println(word);

        for(char c : word.toCharArray()){
            int i = c - 'a';
            if(cur.children[i] == null) cur.children[i] = new TrieNode();
            // System.out.println((char)(i  + 'a'));

            cur = cur.children[i];
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
            System.out.println(word);

        return find(word, 0, root, false);
    }

    private boolean find(String word, int idx, TrieNode root, boolean isEnd){
        if(idx == word.length()){
            // System.out.println(isEnd);

            if(isEnd) return true;
            // return true;
            return false;
        } 
        if(root == null) return false;

        char c = word.charAt(idx);
        if(c == '.'){
            for(TrieNode node : root.children){
                if(node != null && find(word, idx + 1, node, node.isEnd)) return true;
            }
            // return false;

        } else {
            int i = c - 'a';
            System.out.println(c);
            if(root.children[i] != null){
                if(find(word, idx + 1, root.children[i], root.children[i].isEnd)) return true;
            }
            // return false;
        }
        return false;
    }
    // I'm not sure about how to delgate boolean words
}

// 10:04 - 10:24

// I'll use trie node calss of 26 chars
// the new part is implementing . 
    // for that i have to go through all chars when there is a dot
    // and if I find next char or next is also do continue.

    // It is like I have to find every other possibility to find the char - I may have to use backtrack
    // recusively search for in this part or in this part

    // recursion search
    // string
    // if idx == n & if it is end - return true or false
    // get trie node if it is char - continue - recurse - to find next node
    // for each trie node - of recursively find next char
    // 
