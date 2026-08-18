class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int idx){
        if(idx == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int num  : nums) list.add(num);
            res.add(list);
        }

        for(int i = idx; i < nums.length; i++){
            if(i > idx && nums[idx] == nums[i]) continue;
            swap(nums, idx, i);
            dfs(nums, idx + 1);
        }

        for(int j = nums.length - 1; j > idx; j--){
            swap(nums, j, idx);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}