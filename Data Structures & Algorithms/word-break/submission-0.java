class Solution {
    private Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        memo = new Boolean[s.length()];
        return dfs(s,set,0);
    }

    private boolean dfs(String s, Set<String> wordDict, int i){
        if(i == s.length()){
            return true;
        }

        if (memo[i] != null) {
            return memo[i];
        }

        for(int j = i; j < s.length(); j++){
            if(wordDict.contains(s.substring(i, j + 1))){
                if(dfs(s, wordDict, j + 1)) {
                    memo[i] = true;
                    return true;
                }
            }
        }
        
        memo[i] = false;
        return false;
    }
}

// using backtacking
// keep expanding the substring - if contains - continue
// then - keep expanding - through backtracking
// if we reach the end we have sentence we return true
// 

// 
