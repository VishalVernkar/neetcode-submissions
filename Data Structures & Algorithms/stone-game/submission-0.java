class Solution {
    int[][] dp;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];
        int sum = 0;
        for(int pile : piles) sum += pile;
        // System.out.println(sum);
        int alice = dfs(piles, 0, n - 1);
        int bob = sum - alice;
        // System.out.println(res);
        return alice > bob;
    }

    private int dfs(int[] piles, int l, int r){
        if(l > r) return 0; 

        if(dp[l][r] != 0) return dp[l][r];

        boolean even = (r - l) % 2 == 0;

        int left = (even)? piles[l] : 0;
        int right = (even)? piles[r] : 0;
        
        dp[l][r] = Math.max( dfs(piles, l + 1, r) + left, dfs(piles, l, r - 1) + right);
        return dp[l][r];
    }
}

// I'm not gonna give up over one problem - ove one frustration - I want to solve - I'm going to solve this problem

// there are even number of stones
// alice always picks first
// then bob - bob picks when ther are odd number of stones
// they can pick from beginning or end
// I have two choice - I have to return the max of this