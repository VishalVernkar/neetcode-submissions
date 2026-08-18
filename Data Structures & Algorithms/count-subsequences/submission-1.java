class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(s,t,0,0);
    }

    private int dfs(String s, String t, int i, int j){
        if(j == t.length()) return 1;
        if(i >= s.length()) return 0; 
        if(dp[i][j] != -1) return dp[i][j];

        int res = 0;
        for(int idx = i; idx < s.length(); idx++){
            if(s.charAt(idx) == t.charAt(j)){
                res += dfs(s, t, idx + 1, j + 1);
            }
        }

        dp[i][j] = res;

        return dp[i][j];
    }
}

// numbver of ways to creat the given word ""
// back track
// 

// 
