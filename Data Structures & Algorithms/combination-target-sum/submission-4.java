class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, 0, target, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, int i, int target, List<Integer> list, int curSum){
        if(i >= nums.length || curSum > target) return;
        if(curSum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        dfs(nums, i, target, list, curSum + nums[i]);
        list.remove(list.size() - 1);
        dfs(nums, i + 1, target, list, curSum);
    }
}

// what makes the sum 
// try every possible  combination

// at a point
// choose the current number again - choose next number
// 
