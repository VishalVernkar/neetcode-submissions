class Solution {
    private class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private void addWord(TrieNode root, String word){
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.children[c - 'a'] == null) cur.children[c - 'a'] = new TrieNode();
            cur = cur.children[c - 'a'];
        }
        cur.isEnd = true;
    }

    public int minExtraChar(String s, String[] dictionary) {
        TrieNode dict = new TrieNode();
        for(String word : dictionary) addWord(dict, word);
        Integer[] dp = new Integer[s.length()];
        return dfs(s, dict, 0, dp);
    }

    private int dfs(String s, TrieNode dict, int start, Integer[] dp){
        if(start == s.length()) return 0;
        if(dp[start] != null) return dp[start];

        // the current char not found
        int res = 1 + dfs(s, dict, start + 1, dp);
        TrieNode cur = dict;
        for(int i = start; i < s.length(); i++){
            char c = s.charAt(i);
            if(cur.children[c -'a'] == null) break;
            cur = cur.children[c -'a'];
            if(cur.isEnd){
                res = Math.min(res, dfs(s, dict, i + 1, dp));
            }
        }
        return dp[start] = res; 
    }
}

// 13:41 - 14:00

// Question
// return the count of unmatched characters

// steps
// dfs
// for a characrter - we can either consider it is not found
// or try every substring from that char - searh it
// we can try every substring and look for in a dictionary
// count the chars not found in each path
// the recursion keeps visiting the same path - makes redundant 
// so we can use dp - to track the not found chars at each index
// and when dfs reach that point we can directly return that count
// 
// intead of substring - we can use - trie node
// skips the frequent - fetching of substrings
