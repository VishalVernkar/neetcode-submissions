class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        dp = new int[coins.length][amount + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return dfs(amount, 0, coins, 0);
    }

    private int dfs(int amount, int target, int[] coins, int i){
        if(target == amount) return 1;
        if(target > amount || i >= coins.length) return 0;
        
        if(dp[i][target] != -1) return dp[i][target];

        dp[i][target] = dfs(amount, target + coins[i], coins, i) + dfs(amount, target, coins, i + 1);

        return dp[i][target];
    }
}


// at a point 
// I have coins - I can choose any number of coins
// I can choose the same coin or move to next 
// once we reach the target - we have the result - we rturn one
