class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for(int coin : coins){
            for(int target = coin; target <= amount; target++){
                dp[target] = Math.min(dp[target], 1 + dp[target - coin]);
            }
        }

        return (dp[amount] == amount + 1)? -1 : dp[amount];
    }
}





// 
// I have coins - I have to use them - use minimum amount of them - to get the target amount
// I can use same coins or choose next at a point
// 

// Brute force
// using every possible combinations
// at a point choose the same coin or next coin
// once we reach the target - we stop 

// dfs
//      12
//  1   5   10
//1 5 10

// I can optimize it using the DP
// from the amount 1 to 12
// we start with best way to reach the current amount
// we use it in the current coin - we take the best value from diff 
// we start from 1 to target
// we use each the coins from avaialble ones 
// 
