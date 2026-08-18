class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int target, int i, List<Integer> list){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        // if(i >= nums.length || target < 0) return;

        for(int j = i; j < nums.length; j++){
            if(j > i && nums[j] == nums[j - 1]) continue;
            if(nums[j] > target) break;
            list.add(nums[j]);
            dfs(nums, target - nums[j], j + 1, list);
            list.remove(list.size() - 1);
        }
        // list.add(nums[i]);
        // dfs(nums, target - nums[i], i + 1, list);
        // list.remove(list.size() - 1);
        // dfs(nums, target, i + 1, list);
    }
}

// 1 2 2 4

// at a point
// choose the number - movet to next
// not choose the number - move to next
// like subsets