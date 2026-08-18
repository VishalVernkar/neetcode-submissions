class Solution {
    Map<String, Integer> dp = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0, 0);
    }


    private int dfs(int[] nums, int target, int sum, int i){
        if(i == nums.length) {
            return (target == sum)? 1 : 0;
        }
        String key = i + "-" + sum;

        if(dp.containsKey(key)) return dp.get(key);
        int res = dfs(nums, target, sum + nums[i], i + 1) + dfs(nums, target, sum - nums[i], i + 1);
        dp.put(key, res);
        return res;
    }
}
