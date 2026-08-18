class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int i, List<Integer> subset){
        
        res.add(new ArrayList<>(subset));

        for(int j = i; j < nums.length; j++){
            subset.add(nums[j]);
            backtrack(nums, j + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }
}