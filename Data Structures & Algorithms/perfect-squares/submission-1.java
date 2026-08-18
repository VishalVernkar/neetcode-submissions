class Solution {
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            int square = i * i;
            if(square <= n ){
                if(square == n) return 1;
                list.add(square);
            } else {
                break;
            }
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for(int num : list){
            for(int target = num; target <= n; target++){
                 dp[target] = Math.min(dp[target], 1 + dp[target - num]);
            }
        }
        return dp[n];
    }
}

// 13
// squares less than < 13
// 1 4 9 < 13

// Brute force
// get all the squares in list < n
// use dfs similar to previous one
// buidl the DP from 0 to target - store min nums required.
// the nums required to get the cur sum

//         1
//      2     
//        