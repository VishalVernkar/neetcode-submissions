class Solution {
    public int subsetXORSum(int[] nums) {
        return backtrack(nums, 0, 0);
    }

    private int backtrack(int[] nums, int i, int xor){
        if(i >= nums.length) return xor;

        int included = backtrack(nums, i + 1, xor ^ nums[i]);
        int excluded = backtrack(nums, i + 1, xor);

        return included + excluded;
    }
}

// 11:35 - 11:45

// Get xor of all the possible subsets

// subsets
// at any given point choose a number
// skip that number