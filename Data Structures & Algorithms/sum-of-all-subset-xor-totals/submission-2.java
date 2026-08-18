class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int index, int xor){
        if(index == nums.length) return xor;

        int include = dfs(nums, index + 1, xor^nums[index]);
        int exclude = dfs(nums, index + 1, xor);

        return include + exclude;
    }
}

// get every possible combination
// back tracking
// for each number we have to choice - include it or exclude it
// we do this recusrsively with every other element 
//