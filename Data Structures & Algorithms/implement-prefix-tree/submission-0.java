class PrefixTree {
    private TrieNode root;

    private class TrieNode{
        TrieNode[] trieNodes = new TrieNode[26];
        boolean isEndOfWord;
    }

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        // System.out.println(word);

        for(char c : word.toCharArray()){
            if(cur.trieNodes[c - 'a'] != null) {
                cur = cur.trieNodes[c - 'a'];
                continue;
            }
            // while(cur.trieNodes[c - 'a'] != null){
            //     cur = cur.trieNodes[c - 'a'];
            // }
            cur.trieNodes[c - 'a'] = new TrieNode();
            cur = cur.trieNodes[c - 'a'];
            cur.isEndOfWord = false;
        }
        cur.isEndOfWord = true;

    }

    public boolean search(String word) {
        TrieNode cur = root;
        // System.out.println(word);
        for(char c : word.toCharArray()){
            // System.out.println(cur.trieNodes[c - 'a']);
            // System.out.println(c - 'a');
            if(cur.trieNodes[c - 'a'] == null){
                return false;
            } else {
                cur = cur.trieNodes[c - 'a'];
            }
        }

        return (cur.isEndOfWord)? true : false;
    }

    public boolean startsWith(String prefix) {
         TrieNode cur = root;
        for(char c : prefix.toCharArray()){
            if(cur.trieNodes[c - 'a'] == null){
                return false;
            } else {
                cur = cur.trieNodes[c - 'a'];
            }
        }
        return true;
    }
}

// 20:30 - 20:50

// create a tire node 
// each node should have a 26 chars
// create a child node
// for every other character
