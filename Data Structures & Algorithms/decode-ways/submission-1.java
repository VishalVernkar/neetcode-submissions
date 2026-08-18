class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        dp[s.length()] = 1;
        return dfs(s, 0);
    }

    private int dfs(String s, int i){
        if(dp[i] != -1) return dp[i];
        if(s.charAt(i) == '0') return 0;

        int res = dfs(s, i + 1);
        if(i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))){
            res += dfs(s, i + 2);
        }

        dp[i] = res;

        return dp[i];
    }
}


// 
// at a point we can pick a number
// or pick two number
// the first number cannot be zero

// the next number if starts with 2 and ends with < 7 then - we can continue
// 