class Solution {
    Set<String> set;
    Boolean[] dp;
    int t;
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        dp = new Boolean[n + 1];
        dp[n] = true;
        set = new HashSet<>(wordDict);
        t = 0;
        for(String word : wordDict){
            t = Math.max(t, word.length());
        }

        return dfs(s, set, 0);
    }

    private boolean dfs(String s, Set<String> wordDict, int i){
        if(dp[i] != null) return dp[i];

        for(int j = i; j < Math.min(i + t, s.length()); j++){
            if(wordDict.contains(s.substring(i, j + 1))){
                if(dfs(s, wordDict, j + 1)){
                    dp[i] = true;
                    return true;
                }
            }
        }
        
        dp[i] = false;
        return false;
    }
}
