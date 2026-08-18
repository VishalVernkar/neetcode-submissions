class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, 0, new HashSet<>(), new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int i, Set<Integer> set, List<Integer> list){
        if(set.size() == nums.length){
            res.add(new ArrayList<>(list));
        }

        for(int j = 0; j < nums.length; j++){
            if(set.contains(nums[j])) continue;
            set.add(nums[j]);
            list.add(nums[j]);
            dfs(nums, j + 1, set, list);
            set.remove(nums[j]);
            list.remove(list.size() - 1);
        }
    }
}

// permutation
// at each place - place one and 
// move to next


// using hashset